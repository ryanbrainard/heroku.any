package com.heroku.api;

public interface Action<R> {
    String httpMethod();
    String path();
    Object requestEntity();
    java.util.Collection<Integer> expectedStatuses();
    Class<R> responseClass();
}