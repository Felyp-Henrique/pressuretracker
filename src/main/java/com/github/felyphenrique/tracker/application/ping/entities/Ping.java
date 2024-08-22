package com.github.felyphenrique.tracker.application.ping.entities;

import java.time.LocalDateTime;

public class Ping {
    public static final String STATUS_STOPED = "stoped";
    public static final String STATUS_STARTED = "started";

    private String description;
    private String status;

    public Ping() {
        this.description = "";
        this.status = STATUS_STOPED;
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

    public static Ping getStoped() {
        final Ping ping = new Ping();
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        ping.setDescription("(%s) The service doesn't working!".formatted(localDateTimeNow.toString()));
        ping.setStatus(STATUS_STOPED);
        return ping;
    }

    public static Ping getStarted() {
        final Ping ping = new Ping();
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        ping.setDescription("(%s) The service is working right now!".formatted(localDateTimeNow.toString()));
        ping.setStatus(STATUS_STARTED);
        return ping;
    }
}
