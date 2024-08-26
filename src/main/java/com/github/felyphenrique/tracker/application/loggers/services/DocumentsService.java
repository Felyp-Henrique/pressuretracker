package com.github.felyphenrique.tracker.application.loggers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

@Service()
public class DocumentsService {
    private final EntityManager entityManager;

    @Autowired()
    public DocumentsService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void teste() {
        this.entityManager.contains(null);
    }
}
