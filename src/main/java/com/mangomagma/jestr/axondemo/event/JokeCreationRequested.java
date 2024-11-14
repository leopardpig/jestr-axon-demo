package com.mangomagma.jestr.axondemo.event;

import com.mangomagma.jestr.axondemo.resource.CreateJokeRequest;

import java.util.UUID;

public final class JokeCreationRequested {
    private final UUID jokeId;
    private final String contributor;
    private final String setup;
    private final String punchline;

    public JokeCreationRequested(final UUID jokeId, final CreateJokeRequest createJokeRequest) {
        this.jokeId = jokeId;
        this.contributor = createJokeRequest.getContributor();
        this.punchline = createJokeRequest.getPunchline();
        this.setup = createJokeRequest.getSetup();
    }

    public UUID getJokeId() {
        return jokeId;
    }

    public String getContributor() {
        return contributor;
    }

    public String getPunchline() {
        return punchline;
    }

    public String getSetup() {
        return setup;
    }
}
