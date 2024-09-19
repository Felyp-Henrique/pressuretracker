package com.github.felyphenrique.tracker.presentations.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
public class PingController {

    @GetMapping
    public @ResponseBody ResponseEntity<String> index() {
        return ResponseEntity.ok("Ok!");
    }
}
