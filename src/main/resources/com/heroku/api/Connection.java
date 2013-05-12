package com.heroku.api;

public interface Connection {
    <R> R execute(Action<R> action);
}
