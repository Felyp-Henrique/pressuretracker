package com.github.felyphenrique.tracker.application.ping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.ping.entities.Ping;
import com.github.felyphenrique.tracker.application.ping.services.PingService;

@RestController()
@RequestMapping("/api/${tracker.version}/ping")
public class PingController {
    private final PingService servicePing;

    @Autowired()
    public PingController(PingService servicePing) {
        this.servicePing = servicePing;
    }

    @GetMapping()
    public @ResponseBody() Ping index() {
        return this.servicePing.getPing();
    }
}
