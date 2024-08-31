package com.github.felyphenrique.tracker.application.loggers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.loggers.repositories.DocumentsDataBaseRepository;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Service()
public class DocumentsIntegrationsService {
    private final DocumentsDataBaseRepository repository;

    @Autowired()
    public DocumentsIntegrationsService(DocumentsDataBaseRepository repository) {
        this.repository = repository;
    }

    public Page<DocumentsDataBaseRepository.DocumentsProjection> getDocuments(final String integrationId, final Pageable pageable) {
        return this.getDocuments(integrationId, Status.ACTIVED, pageable);
    }

    public Page<DocumentsDataBaseRepository.DocumentsProjection> getDocuments(final String integrationId, final Status status, final Pageable pageable) {
        return this.repository.findByIntegrationIdAndStatus(integrationId, status, pageable);
    }
}
