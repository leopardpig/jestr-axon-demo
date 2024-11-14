package com.mangomagma.jestr.axondemo.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AssignJokeRequest {

    @NotBlank(message = "username is required")
    @Size(max = 50, message = "username must not exceed 50 characters")
    private String username;

    AssignJokeRequest() {}

    AssignJokeRequest(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

}



