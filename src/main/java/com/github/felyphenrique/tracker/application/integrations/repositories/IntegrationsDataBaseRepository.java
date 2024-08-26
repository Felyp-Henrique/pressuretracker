package com.github.felyphenrique.tracker.application.integrations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;

@Repository()
public interface IntegrationsDataBaseRepository extends JpaRepository<Integration, Integer> {

}
