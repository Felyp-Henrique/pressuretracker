package com.github.felyphenrique.tracker.application.loggers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.loggers.repositories.DocumentsDataBaseRepository;
import com.github.felyphenrique.tracker.application.loggers.services.DocumentsIntegrationsService;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@RestController()
@RequestMapping("/api/${tracker.version}/documents/integrations")
public class DocumentsIntegrationsController {
    private final DocumentsIntegrationsService service;

    @Autowired()
    public DocumentsIntegrationsController(DocumentsIntegrationsService service) {
        this.service = service;
    }

    @GetMapping("/{integration_id}")
    public @ResponseBody() ResponseEntity<Page<DocumentsDataBaseRepository.DocumentsProjection>> index(
            @PathVariable("integration_id") String integrationId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "page_size", defaultValue = "20") int pageSize,
            @RequestParam(value = "order", defaultValue = "desc") String order,
            @RequestParam(value = "order_field", defaultValue = "createdAt") String orderField,
            @RequestParam(value = "filter_status", defaultValue = "1") int filterStatus) {
        final Status status = Status.valueOf(filterStatus);
        final Sort sort = Sort.by(Direction.fromString(order), orderField);
        final PageRequest pageable = PageRequest.of(page, pageSize, sort);
        final Page<DocumentsDataBaseRepository.DocumentsProjection> response = this.service.getDocuments(
                integrationId, status, pageable);
        return ResponseEntity.ok(response);
    }
}
