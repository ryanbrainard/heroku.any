package com.heroku.api;

public interface Action<R> {
    R getResource();
    String getHttpMethod();
    String getEndpoint();
    int getExpectedStatus();
}