package com.github.felyphenrique.tracker.application.ping.configurations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;

import com.github.felyphenrique.tracker.application.ping.entities.Ping;
import com.github.felyphenrique.tracker.application.ping.proxies.PingProxy;

import jakarta.servlet.http.HttpServletRequest;

@Configuration()
public class PingProxyConfiguration {

    @Autowired()
    @Bean(name = "proxies_ping")
    @RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public PingProxy pingProxy(HttpServletRequest request, MessageSource messageSource) {
        final String language = Objects.toString(request.getParameter("lang"), "pt-br");
        final Locale locale = Locale.forLanguageTag(language);
        final LocalDateTime localDateTimeNow = LocalDateTime.now();
        final Ping ping = new Ping();
        final String pingDescription = messageSource.getMessage(
                "api.ping.started.description", Arrays.asList(localDateTimeNow.toString()).toArray(), locale);
        final String pingStatus = messageSource.getMessage(
                "api.ping.started.status", null, locale);
        ping.setDescription(pingDescription);
        ping.setStatus(pingStatus);
        return new PingProxy(ping);
    }
}
