package com.github.felyphenrique.tracker.application.integrations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;
import com.github.felyphenrique.tracker.application.integrations.repositories.IntegrationsDataBaseRepository;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Service()
public class IntegrationsService {
    private final IntegrationsDataBaseRepository repository;

    @Autowired()
    public IntegrationsService(IntegrationsDataBaseRepository repository) {
        this.repository = repository;
    }

    public Page<Integration> index(final Pageable pageable) {
        return this.repository.findByStatus(Status.ACTIVED, pageable);
    }
}
