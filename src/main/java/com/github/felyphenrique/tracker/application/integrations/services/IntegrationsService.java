package com.github.felyphenrique.tracker.application.integrations.services;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.integrations.entities.Integration;
import com.github.felyphenrique.tracker.application.integrations.repositories.IntegrationsDataBaseRepository;
import com.github.felyphenrique.tracker.kernel.entities.Status;

@Service()
public class IntegrationsService {
    private final IntegrationsDataBaseRepository repository;

    @Autowired()
    public IntegrationsService(IntegrationsDataBaseRepository repository) {
        this.repository = repository;
    }

    public Page<Integration> index(final Pageable pageable) {
        return this.repository.findByStatus(Status.ACTIVED, pageable);
    }

    public Integration detail(final String id) {
        return this.repository.findById(id).orElseThrow();
    }

    public Integration create(Integration integration) {
        final LocalDateTime localDateTimeNow = LocalDateTime.now();
        final byte[] localDateTimeNowAsBytes = localDateTimeNow.toString().getBytes();
        final Encoder encoderBase64 = Base64.getEncoder();
        final String tokenBase64 = encoderBase64.encodeToString(localDateTimeNowAsBytes);
        integration.setStatus(Status.ACTIVED);
        integration.setToken(tokenBase64);
        integration.setCreatedAt(localDateTimeNow);
        return this.repository.save(integration);
    }

    public Integration update(Integration integration) {
        final LocalDateTime localDateTimeNow = LocalDateTime.now();
        integration.setUpdatedAt(localDateTimeNow);
        return this.repository.save(integration);
    }

    public void delete(final String id) {
        this.repository.deleteById(id);
    }
}
