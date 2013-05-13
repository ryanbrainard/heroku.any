package com.heroku.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class JerseyClientConnection implements Connection {

    private final Client client; // TODO: lazy static??
    private final WebResource baseResource;

    public JerseyClientConnection(String apiKey) {
        client = Client.create();
        baseResource = client.resource("https://api.heroku.com");
        baseResource.addFilter(new HTTPBasicAuthFilter("", apiKey));
    }

    @Override
    public <R> R execute(Action<R> action) {
        return baseResource
                .path(action.path())
                .method(action.httpMethod(),
                        action.responseClass(),
                        action.requestEntity()
                );
    }
}