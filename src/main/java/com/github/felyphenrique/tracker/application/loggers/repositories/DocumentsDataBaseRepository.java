package com.github.felyphenrique.tracker.application.loggers.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.application.loggers.entities.Document;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Repository()
public interface DocumentsDataBaseRepository extends JpaRepository<Document, String> {

    public Page<DocumentsProjection> findByStatus(@Param("status") Status status, Pageable pageable);

    public Page<DocumentsProjection> findByIntegrationId(
            @Param("integration_id") String integrationId, Pageable pageable);

    public Page<DocumentsProjection> findByIntegrationIdAndStatus(
            @Param("integration_id") String integrationId, @Param("status") Status status, Pageable pageable);

    @Modifying()
    @Query(value = "update document d set d.status = :status where d.id = :id", nativeQuery = true)
    public void updateDocumentSetStatusForId(@Param("id") String id, @Param("status") Status status);

    public static interface DocumentsProjection {

        public String getId();

        public String getMessageShort();

        public String getCreatedAt();
    }
}
