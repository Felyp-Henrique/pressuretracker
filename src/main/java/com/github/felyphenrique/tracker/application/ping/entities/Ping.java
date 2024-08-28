package com.github.felyphenrique.tracker.application.ping.entities;

public class Ping {
    private String description;
    private String status;

    public Ping() {
        this.description = "";
        this.status = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
