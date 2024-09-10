package com.github.felyphenrique.tracker.application.integrations.dtos;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;
import com.github.felyphenrique.tracker.kernel.entities.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public final record IntegrationUpdateRequest(
        @NotBlank(message = "Descrição não pode estar em branco!") @NotNull(message = "Descrição não pode estar nula!") String description,
        @NotNull(message = "Situação cadastral não pode estar nula!") Status status) {

    public final Integration toEntity(final Integration integration) {
        integration.setDescription(description);
        integration.setStatus(status);
        return integration;
    }
}
