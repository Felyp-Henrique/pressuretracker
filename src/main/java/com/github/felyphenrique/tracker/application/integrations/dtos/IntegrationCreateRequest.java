package com.github.felyphenrique.tracker.application.integrations.dtos;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public final record IntegrationCreateRequest(
        @NotBlank(message = "Descrição não pode estar em branco!") @NotNull(message = "Descrição não pode estar nula!") String description) {

    public final Integration toEntity() {
        final Integration integration = new Integration();
        integration.setDescription(this.description);
        return integration;
    }
}
