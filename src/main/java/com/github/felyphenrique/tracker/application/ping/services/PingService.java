package com.github.felyphenrique.tracker.application.ping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.application.ping.entities.Ping;
import com.github.felyphenrique.tracker.application.ping.proxies.PingProxy;

@Service()
public class PingService {
    private PingProxy pingProxy;

    public PingService() {
        this.pingProxy = null;
    }

    @Autowired()
    public void setPingProxy(@Qualifier("proxies_ping") PingProxy pingProxy) {
        this.pingProxy = pingProxy;
    }

    public Ping getPing() {
        return this.pingProxy.getPing();
    }
}
