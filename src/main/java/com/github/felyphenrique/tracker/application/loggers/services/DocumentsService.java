package com.github.felyphenrique.tracker.application.loggers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.loggers.repositories.DocumentsRepository;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Service()
public class DocumentsService {
    private final DocumentsRepository repository;

    @Autowired()
    public DocumentsService(DocumentsRepository repository) {
        this.repository = repository;
    }

    public Page<DocumentsRepository.DocumentsProjection> index(Pageable pageable) {
        return this.repository.findByStatus(Status.ACTIVED, pageable);
    }
}
