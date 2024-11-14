package com.mangomagma.jestr.axondemo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mangomagma.jestr.axondemo.event.JokeCreationRequested;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Joke {

    @Id
    private UUID id;
    private String contributor;
    private String setup;
    private String punchline;
    private String owner;
    private String status;
    private LocalDateTime statusTime;
    private LocalDateTime submitTime;

    public Joke() {}

    public Joke(final JokeCreationRequested event) {
        id = event.getJokeId();
        contributor = event.getContributor();
        punchline = event.getPunchline();
        setup = event.getSetup();
        status = "SUBMITTED";
        LocalDateTime timestamp = LocalDateTime.now();
        statusTime = timestamp;
        submitTime = timestamp;
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


