package com.github.felyphenrique.tracker.application.loggers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.loggers.services.DocumentsIntegrationsService;

@RestController()
@RequestMapping("/api/${tracker.version}/documents")
public class DocumentsController {
    private final DocumentsIntegrationsService service;

    @Autowired()
    public DocumentsController(DocumentsIntegrationsService service) {
        this.service = service;
    }
}
