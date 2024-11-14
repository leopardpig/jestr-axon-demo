package com.mangomagma.jestr.axondemo.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateJokeRequest {

    @NotBlank(message = "contributor is required")
    @Size(max = 50, message = "contributor must not exceed 50 characters")
    private String contributor;
    private String setup;
    @NotBlank(message = "punchline is required")
    private String punchline;

    public String getContributor() {
        return contributor;
    }

    public void setContributor(final String contributor) {
        this.contributor = contributor;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(final String punchline) {
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(final String setup) {
        this.setup = setup;
    }
}


