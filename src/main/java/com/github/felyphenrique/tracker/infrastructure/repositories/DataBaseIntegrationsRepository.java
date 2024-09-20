package com.github.felyphenrique.tracker.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.domain.entities.Integration;
import com.github.felyphenrique.tracker.domain.entities.Status;
import com.github.felyphenrique.tracker.domain.repositories.IntegrationsRepository;

@Repository
public interface DataBaseIntegrationsRepository extends IntegrationsRepository, JpaRepository<Integration, Integer> {

    @Override
    public List<Integration> findByStatus(@Param("status") Status status);
}
