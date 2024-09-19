package com.github.felyphenrique.tracker.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.dtos.IntegrationIndexResponse;
import com.github.felyphenrique.tracker.application.mappers.IntegrationsResponsesMapper;
import com.github.felyphenrique.tracker.domain.entities.Integration;
import com.github.felyphenrique.tracker.domain.services.IntegrationsService;

@Service
public class IntegrationsIndexService {
    private final IntegrationsService integrationsService;
    private final IntegrationsResponsesMapper integrationsResponsesMapper;

    @Autowired
    public IntegrationsIndexService(IntegrationsService integrationsService, IntegrationsResponsesMapper mapper) {
        this.integrationsService = integrationsService;
        this.integrationsResponsesMapper = mapper;
    }

    public List<IntegrationIndexResponse> index() {
        final List<Integration> integrations = this.integrationsService.getAllIntegrations();
        final List<IntegrationIndexResponse> responses = this.integrationsResponsesMapper.asIndexResponse(integrations);
        return responses;
    }
}
