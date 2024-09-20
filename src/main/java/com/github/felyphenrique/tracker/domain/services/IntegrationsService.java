package com.github.felyphenrique.tracker.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.domain.entities.Integration;
import com.github.felyphenrique.tracker.domain.entities.Status;
import com.github.felyphenrique.tracker.domain.repositories.IntegrationsRepository;

@Service
public class IntegrationsService {
    private final IntegrationsRepository integrationsRepository;

    @Autowired
    public IntegrationsService(IntegrationsRepository integrationsRepository) {
        this.integrationsRepository = integrationsRepository;
    }

    public final List<Integration> getAllIntegrations() {
        return this.integrationsRepository.findByStatus(Status.ACTIVE);
    }
}
