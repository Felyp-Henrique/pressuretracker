package com.github.felyphenrique.tracker.application.integrations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;
import com.github.felyphenrique.tracker.application.integrations.services.IntegrationsService;

@RestController()
@RequestMapping("/api/${tracker.version}/integrations")
public class IntegrationsController {
    private final IntegrationsService service;

    @Autowired()
    public IntegrationsController(IntegrationsService service) {
        this.service = service;
    }

    @GetMapping()
    public @ResponseBody() ResponseEntity<Page<Integration>> index(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "page_size", defaultValue = "10") int pageSize,
            @RequestParam(name = "order", defaultValue = "desc") String order,
            @RequestParam(name = "order_field", defaultValue = "createdAt") String orderField) {
        final Sort sort = Sort.by(Direction.fromString(order), orderField);
        final Pageable pageable = PageRequest.of(page, pageSize, sort);
        final Page<Integration> response = this.service.index(pageable);
        return ResponseEntity.ok(response);
    }
}
