package com.mangomagma.jestr.axondemo.resource;

import java.util.UUID;

public class CreateJokeResponse {

    UUID jokeId;

    public CreateJokeResponse() {}

    public CreateJokeResponse(final UUID jokeId) {
        this.jokeId = jokeId;
    }

    public UUID getJokeId() {
        return jokeId;
    }
}
