package com.github.felyphenrique.tracker.application.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.felyphenrique.tracker.application.dtos.IntegrationIndexResponse;
import com.github.felyphenrique.tracker.domain.entities.Integration;

@Component
public class IntegrationsResponsesMapper {

    public List<IntegrationIndexResponse> asIndexResponse(final List<Integration> integrations) {
        return integrations.stream().map(IntegrationIndexResponse::from).toList();
    }
}
