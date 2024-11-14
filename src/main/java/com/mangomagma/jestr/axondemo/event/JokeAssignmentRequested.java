package com.mangomagma.jestr.axondemo.event;

import com.mangomagma.jestr.axondemo.resource.AssignJokeRequest;

import java.util.UUID;

public final class JokeAssignmentRequested {
    private final UUID jokeId;
    private final AssignJokeRequest assignJokeRequest;

    public JokeAssignmentRequested(final UUID jokeId, final AssignJokeRequest assignJokeRequest) {
      this.jokeId = jokeId;
      this.assignJokeRequest = assignJokeRequest;
    }

    public UUID getJokeId() {
      return jokeId;
    }

    public AssignJokeRequest getAssignJokeRequest() {
      return assignJokeRequest;
    }

}


