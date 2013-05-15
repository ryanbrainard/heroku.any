package com.heroku.api;

// TODO: break out request and response classes into multiple generics?
public interface Action<R> {
    String httpMethod();
    String path();
    int expectedStatus();
    Class<R> responseClass();
}