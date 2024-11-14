package com.mangomagma.jestr.axondemo.resource;

import com.mangomagma.jestr.axondemo.entity.Joke;


import java.time.LocalDateTime;
import java.util.UUID;

public class GetJokeResponse {

    private UUID id;
    private String contributor;
    private String setup;
    private String punchline;
    private String owner;
    private String status;
    private LocalDateTime statusTime;
    private LocalDateTime submitTime;

    public GetJokeResponse() {}

    public GetJokeResponse(final Joke joke) {
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

    public void setContributor(final String contributor) {
        this.contributor = contributor;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(final String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(final String punchline) {
        this.punchline = punchline;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LocalDateTime getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(final LocalDateTime statusTime) {
        this.statusTime = statusTime;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(final LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }
}


