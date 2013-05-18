package com.heroku.api;

public interface Connection {
    <R> R execute(Action<R> action);
    <R> Iterable<R> executeList(final Action<java.util.List<R>> action);
}
