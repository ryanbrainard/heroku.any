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
import java.util.Map;

public class JerseyClientConnection implements Connection {

    private final Client client; // TODO: lazy static??
    private final WebResource baseResource;

    public JerseyClientConnection(String apiKey) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(clientConfig);
        baseResource = client.resource("https://api.heroku.com");
        baseResource.addFilter(new HTTPBasicAuthFilter("", apiKey));
        baseResource.addFilter(new LoggingFilter());
    }

    @Override
    public <R> R execute(Action<R> action) {
        final ClientResponse response = baseResource
                .path(action.path())
                .entity(action.requestEntity(), MediaType.APPLICATION_JSON_TYPE)
                .accept("application/vnd.heroku+json; version=3")
                .method(action.httpMethod(), ClientResponse.class);

        if (action.expectedStatuses().contains(response.getStatus())) {
            return response.getEntity(action.responseType());
        } else {
            final Map error = response.getEntity(Map.class);
            throw new HerokuApiException(String.valueOf(error.get("id")), String.valueOf(error.get("message")), response.getStatus());
        }
    }
}