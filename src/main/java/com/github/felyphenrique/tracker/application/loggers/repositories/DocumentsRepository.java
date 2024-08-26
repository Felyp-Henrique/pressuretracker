package com.github.felyphenrique.tracker.application.loggers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.application.loggers.entities.Document;

@Repository()
public interface DocumentsRepository extends JpaRepository<Document, Integer> {

}
