package com.heroku.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public class JerseyClientConnection implements Connection {

    private final Client client; // TODO: lazy static??
    private final WebResource baseResource;

    public JerseyClientConnection(String apiKey) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(clientConfig);
        baseResource = client.resource("https://api.heroku.com");
        baseResource.addFilter(new HTTPBasicAuthFilter("", apiKey));
    }

    @Override
    public <R> R execute(Action<R> action) {
        return baseResource
                .path(action.path())
                .entity(action.httpMethod().equals("GET") ? null : action.requestEntity(), "application/json")
                .accept("application/vnd.heroku+json; version=3")
                .method(action.httpMethod(), action.responseClass());
    }
}