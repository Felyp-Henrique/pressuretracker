package com.github.felyphenrique.tracker.application.integrations.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "integrations")
public class Integration {
    public static final int INTEGRATION_STATUS_INACTIVE = 0;
    public static final int INTEGRATION_STATUS_ACTIVE = 1;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "token")
    private String token;

    @Column(name = "status")
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
