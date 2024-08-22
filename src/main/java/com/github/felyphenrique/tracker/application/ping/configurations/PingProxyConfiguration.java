package com.github.felyphenrique.tracker.application.ping.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;

import com.github.felyphenrique.tracker.application.ping.entities.Ping;
import com.github.felyphenrique.tracker.application.ping.proxies.PingProxy;

@Configuration()
public class PingProxyConfiguration {

    @Bean(name = "proxies_ping")
    @RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public PingProxy pingProxy() {
        return new PingProxy(Ping.getStarted());
    }
}
