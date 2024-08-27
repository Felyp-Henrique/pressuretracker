package com.github.felyphenrique.tracker.application.loggers.entities;

import com.github.felyphenrique.tracker.kernel.entities.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "documents")
public final class Document {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "message_short", nullable = false, length = 180)
    private String messageShort;

    @Column(name = "message_long", nullable = false, length = 255)
    private String messageLong;

    @Column(name = "created_at")
    private String createdAt;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status status;

    public Document() {
        this.id = 0;
        this.messageShort = "";
        this.messageLong = "";
        this.createdAt = "";
        this.status = Status.INACTIVATED;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageShort() {
        return messageShort;
    }

    public void setMessageShort(String messageShort) {
        this.messageShort = messageShort;
    }

    public String getMessageLong() {
        return messageLong;
    }

    public void setMessageLong(String messageLong) {
        this.messageLong = messageLong;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
