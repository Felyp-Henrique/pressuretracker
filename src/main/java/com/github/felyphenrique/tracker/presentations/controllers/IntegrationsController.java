package com.github.felyphenrique.tracker.presentations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.dtos.IntegrationIndexResponse;
import com.github.felyphenrique.tracker.application.services.IntegrationsIndexService;

@RestController
@RequestMapping("/api/integrations")
public class IntegrationsController {
    private final IntegrationsIndexService integrationsIndexService;

    @Autowired
    public IntegrationsController(IntegrationsIndexService integrationsIndexService) {
        this.integrationsIndexService = integrationsIndexService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<IntegrationIndexResponse>> index() {
        return ResponseEntity.ok(this.integrationsIndexService.index());
    }
}
