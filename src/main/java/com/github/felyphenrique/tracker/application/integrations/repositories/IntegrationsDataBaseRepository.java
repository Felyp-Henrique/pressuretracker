package com.github.felyphenrique.tracker.application.integrations.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;

@Repository()
public interface IntegrationsDataBaseRepository extends CrudRepository<Integration, Integer> {

}
