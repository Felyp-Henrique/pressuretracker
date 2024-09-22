package com.github.felyphenrique.tracker.presentations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.felyphenrique.tracker.application.dtos.AuthenticationRequest;
import com.github.felyphenrique.tracker.application.dtos.AuthenticationResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationsController {
    private final SecurityContextRepository securityContextRepository;
    private final SecurityContextHolderStrategy securityContextHolderStrategy;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationsController(AuthenticationManager authenticationManager) {
        this.securityContextRepository = new HttpSessionSecurityContextRepository();
        this.securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    @PostMapping
    public @ResponseBody void create(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody AuthenticationRequest authenticationRequest) {
        final UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(
                authenticationRequest.getEmail(),
                authenticationRequest.getPassword());
        final Authentication authentication = this.authenticationManager.authenticate(token);
        final SecurityContext securityContext = this.securityContextHolderStrategy.createEmptyContext();
        securityContext.setAuthentication(authentication);
        this.securityContextHolderStrategy.setContext(securityContext);
        this.securityContextRepository.saveContext(securityContext, httpServletRequest, httpServletResponse);
    }
}
