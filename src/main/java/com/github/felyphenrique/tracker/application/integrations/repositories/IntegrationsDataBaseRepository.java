package com.github.felyphenrique.tracker.application.integrations.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;

@Repository()
public interface IntegrationsDataBaseRepository extends ReactiveCrudRepository<Integration, Integer> {

}
