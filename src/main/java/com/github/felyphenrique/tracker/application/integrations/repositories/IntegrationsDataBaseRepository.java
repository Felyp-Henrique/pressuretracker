package com.github.felyphenrique.tracker.application.integrations.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Repository()
public interface IntegrationsDataBaseRepository extends JpaRepository<Integration, String> {

    public Page<Integration> findByStatus(@Param("status") Status status, Pageable pageable);

    @Modifying()
    @Query(value = "update integrations i set i.status = :status where i.id = :id", nativeQuery = true)
    public void updateIntegrationSetStatusForId(@Param("id") String id, @Param("status") Status status);
}
