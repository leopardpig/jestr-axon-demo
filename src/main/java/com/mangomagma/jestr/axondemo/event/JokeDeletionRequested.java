package com.mangomagma.jestr.axondemo.event;

import java.util.UUID;

public final class JokeDeletionRequested {
    private final UUID jokeId;

    public JokeDeletionRequested(final UUID jokeId) {
        this.jokeId = jokeId;
    }

    public UUID getJokeId() {
        return jokeId;
    }

}

