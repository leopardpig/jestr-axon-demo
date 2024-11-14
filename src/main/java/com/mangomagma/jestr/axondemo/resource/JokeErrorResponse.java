package com.mangomagma.jestr.axondemo.resource;

public class JokeErrorResponse {

    String message;

    public JokeErrorResponse() {}

    public JokeErrorResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
