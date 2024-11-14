package com.mangomagma.jestr.axondemo.event;

import java.util.UUID;

public final class JokeDeleted {

    final UUID jokeId;

    public JokeDeleted(final UUID jokeId) {
        this.jokeId = jokeId;
    }

    public UUID getJokeId() {
        return jokeId;
    }

}

