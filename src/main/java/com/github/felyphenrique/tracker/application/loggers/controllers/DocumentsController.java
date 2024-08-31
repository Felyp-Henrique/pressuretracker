package com.github.felyphenrique.tracker.application.loggers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.loggers.repositories.DocumentsDataBaseRepository;
import com.github.felyphenrique.tracker.application.loggers.services.DocumentsService;

@RestController()
@RequestMapping("/api/${tracker.version}/documents")
public class DocumentsController {
    private final DocumentsService service;

    @Autowired()
    public DocumentsController(DocumentsService service) {
        this.service = service;
    }

    @GetMapping()
    public @ResponseBody() ResponseEntity<Page<DocumentsDataBaseRepository.DocumentsProjection>> index(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "page_size", defaultValue = "20") int pageSize,
            @RequestParam(value = "order", defaultValue = "desc") String order,
            @RequestParam(value = "order_field", defaultValue = "createdAt") String orderField) {
        final Sort sort = Sort.by(Direction.fromString(order), orderField);
        final PageRequest pageable = PageRequest.of(page, pageSize, sort);
        final Page<DocumentsDataBaseRepository.DocumentsProjection> response = this.service.index(pageable);
        return ResponseEntity.ok(response);
    }
}
