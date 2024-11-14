package com.mangomagma.jestr.axondemo.event;

import com.mangomagma.jestr.axondemo.entity.Joke;
import java.time.LocalDateTime;
import java.util.UUID;

public final class JokeCreated {

    private final UUID id;
    private final String contributor;
    private final String setup;
    private final String punchline;
    private final String owner;
    private final String status;
    private final LocalDateTime statusTime;
    private final LocalDateTime submitTime;

    public JokeCreated(final Joke joke) {
        id = joke.getId();
        contributor = joke.getContributor();
        setup = joke.getSetup();
        punchline = joke.getPunchline();
        owner = joke.getOwner();
        status = joke.getStatus();
        statusTime = joke.getStatusTime();
        submitTime = joke.getSubmitTime();
    }

    public UUID getId() {
        return id;
    }

    public String getContributor() {
        return contributor;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public String getOwner() {
        return owner;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getStatusTime() {
        return statusTime;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

}



