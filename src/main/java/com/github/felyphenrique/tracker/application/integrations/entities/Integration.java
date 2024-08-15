package com.github.felyphenrique.tracker.application.integrations.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "integrations")
public final class Integration {
    public static final int INTEGRATION_STATUS_INACTIVE = 0;
    public static final int INTEGRATION_STATUS_ACTIVE = 1;

    @Id()
    @Column(value = "id")
    private int id;

    @Column(value = "description")
    private String description;

    @Column(value = "token")
    private String token;

    @Column(value = "status")
    private int status;

    public Integration() {
        this.id = 0;
        this.description = "";
        this.token = "";
        this.status = INTEGRATION_STATUS_INACTIVE;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
