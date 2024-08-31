package com.github.felyphenrique.tracker.application.loggers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.loggers.repositories.DocumentsDataBaseRepository;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Service()
public class DocumentsService {
    private final DocumentsDataBaseRepository repository;

    @Autowired()
    public DocumentsService(DocumentsDataBaseRepository repository) {
        this.repository = repository;
    }

    public Page<DocumentsDataBaseRepository.DocumentsProjection> index(final Pageable pageable) {
        return this.repository.findByStatus(Status.ACTIVED, pageable);
    }
}
