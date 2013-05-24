package com.heroku.api;

public class HerokuApiException extends RuntimeException {
    private final String id;
    private final int status;

    public HerokuApiException(String id, String message, int status) {
        super(message);
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }
}
