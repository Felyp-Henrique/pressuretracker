package com.github.felyphenrique.tracker.application.dtos;

import com.github.felyphenrique.tracker.domain.entities.Integration;

public class IntegrationIndexResponse {
    private int id;
    private String description;

    public IntegrationIndexResponse() {
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

    public static final IntegrationIndexResponse from(final Integration integration) {
        final IntegrationIndexResponse integrationIndexResponse = new IntegrationIndexResponse();
        integrationIndexResponse.setId(integration.getId());
        integrationIndexResponse.setDescription(integration.getDescription());
        return integrationIndexResponse;
    }
}
