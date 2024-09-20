package com.github.felyphenrique.tracker.domain.repositories;

import java.util.List;

import com.github.felyphenrique.tracker.domain.entities.Integration;
import com.github.felyphenrique.tracker.domain.entities.Status;

public interface IntegrationsRepository {
    public List<Integration> findAll();

    public List<Integration> findByStatus(Status status);
}
