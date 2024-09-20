package com.github.felyphenrique.tracker.application.dtos;

public final class IntegrationCreateResponse {
    private int id;
    private String description;

    public IntegrationCreateResponse() {
        this.id = 0;
        this.description = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
