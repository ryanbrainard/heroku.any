package com.heroku.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JerseyClientConnection implements Connection {

    private static final NullWebResourceBuilderHandler NULL_WEB_RESOURCE_BUILDER_HANDLER = new NullWebResourceBuilderHandler();
    private static final RangeWarningClientResponseHandler RANGE_WARNING_CLIENT_RESPONSE_HANDLER = new RangeWarningClientResponseHandler();
    private static final Client client;

    static {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(clientConfig);
    }

    private final WebResource baseResource;

    public JerseyClientConnection(String apiKey) {
        baseResource = client.resource("https://api.heroku.com");
        baseResource.addFilter(new HTTPBasicAuthFilter("", apiKey));
        baseResource.addFilter(new LoggingFilter());
    }

    /**
     * Executes a list-based action and returns an iterable that continues to fetch all ranges until complete.
     *
     * Not-thread safe
     */
    public <R> Iterable<R> executeList(final Action<List<R>> action) {
        return new Iterable<R>() {
            final RangeHandler rangeHandler = new RangeHandler();
            Iterator<R> iterator;

            @Override
            public Iterator<R> iterator() {
                return new Iterator<R>() {
                    @Override
                    public boolean hasNext() {
                        if (iterator == null || (!iterator.hasNext() && !rangeHandler.done())) {
                            iterator = execute(action, rangeHandler, rangeHandler).iterator();
                        }
                        return iterator.hasNext();
                    }

                    @Override
                    public R next() {
                        hasNext();
                        return iterator.next();
                    }

                    @Override
                    public void remove() {
                        iterator.remove();
                    }
                };
            }
        };
    }

    /**
     * Executes any action. 
     * Note, list-based actions will only return first range. @see {@link #executeList}
     */
    @Override
    public <R> R execute(final Action<R> action) {
        return execute(action, NULL_WEB_RESOURCE_BUILDER_HANDLER, RANGE_WARNING_CLIENT_RESPONSE_HANDLER);
    }

    private <R> R execute(Action<R> action, WebResourceBuilderHandler webResourceBuilderHandler,ClientResponseHandler clientResponseHandler) {
        final WebResource.Builder builder = baseResource.path(action.path())
                .entity(action.requestEntity(), MediaType.APPLICATION_JSON_TYPE)
                .header("X-Http-Method-Override", action.httpMethod())
                .accept("application/vnd.heroku+json; version=3");

        webResourceBuilderHandler.handle(builder, action);

        final ClientResponse response = builder.method(action.httpMethod().equals("PATCH") ? "POST" : action.httpMethod(), ClientResponse.class);

        clientResponseHandler.handle(response, action);

        if (action.expectedStatuses().contains(response.getStatus())) {
            return response.getEntity(action.responseType());
        } else {
            final Map error = response.getEntity(Map.class);
            throw new HerokuApiException(String.valueOf(error.get("id")), String.valueOf(error.get("message")), response.getStatus());
        }
    }

    private static interface WebResourceBuilderHandler {
        void handle(WebResource.Builder builder, Action action);
    }

    private static interface ClientResponseHandler {
        void handle(ClientResponse response, Action action);
    }

    private static class NullWebResourceBuilderHandler implements WebResourceBuilderHandler {
        @Override
        public void handle(WebResource.Builder builder, Action action) {}
    }

    private static class RangeWarningClientResponseHandler implements ClientResponseHandler {
        @Override
        public void handle(ClientResponse response, Action action) {
            if (response.getStatus() == 206) {
                System.err.println("WARNING: Call to " + action.httpMethod() + " " + action.path() +
                        " returned an incomplete list. Use executeList instead.");
            }
        }
    }

    private static class RangeHandler implements WebResourceBuilderHandler, ClientResponseHandler {
        private String nextRange = null;
        private boolean done = false;

        @Override
        public void handle(WebResource.Builder builder, Action action) {
            if (nextRange != null) {
                builder.header("Range", nextRange);
            } else {
                done = true;
            }
        }

        @Override
        public void handle(ClientResponse response, Action action) {
            if (response.getStatus() == 206 && response.getHeaders().getFirst("Next-Range") != null) {
                nextRange = response.getHeaders().getFirst("Next-Range");
            }
        }

        public boolean done() {
            return done;
        }
    }
}