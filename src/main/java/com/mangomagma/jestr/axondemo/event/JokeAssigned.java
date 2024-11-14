package com.mangomagma.jestr.axondemo.event;

import com.mangomagma.jestr.axondemo.resource.AssignJokeRequest;

import java.util.UUID;

public final class JokeAssigned {

    final UUID jokeId;
    final String owner;

    public JokeAssigned(final UUID jokeId, final AssignJokeRequest assignJokeRequest) {
      this.jokeId = jokeId;
      this.owner = assignJokeRequest.getUsername();
    }

    public UUID getJokeId() {
        return jokeId;
    }

    public String getOwner() {
        return owner;
    }
}
