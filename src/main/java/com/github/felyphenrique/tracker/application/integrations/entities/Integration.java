package com.github.felyphenrique.tracker.application.integrations.entities;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.lang.NonNull;

import com.github.felyphenrique.tracker.application.loggers.entities.Document;
import com.github.felyphenrique.tracker.kernel.entities.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "integrations")
public class Integration {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "token")
    private String token;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "documents", orphanRemoval = true, cascade = { CascadeType.REMOVE })
    private List<Document> documents;

    public Integration() {
        this.id = "";
        this.description = "";
        this.token = "";
        this.createdAt = LocalDateTime.now();
        this.status = Status.INACTIVATED;
        this.documents = Collections.emptyList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(@NonNull() List<Document> documents) {
        this.documents = documents;
    }
}
