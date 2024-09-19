package com.github.felyphenrique.tracker.domain.repositories;

import java.util.List;

import com.github.felyphenrique.tracker.domain.entities.Integration;

public interface IntegrationsRepository {
    public List<Integration> findAll();
}
