package com.github.felyphenrique.tracker.application.loggers.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "loggers_documents")
public final class Document {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "message_short")
    private String messageShort;

    @Column(name = "message_long")
    private String messageLong;

    @Column(name = "created_at")
    private String createdAt;

    public Document() {
        this.id = 0;
        this.messageShort = "";
        this.messageLong = "";
        this.createdAt = "";
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
}
