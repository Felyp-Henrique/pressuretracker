package com.github.felyphenrique.tracker.application.audities.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.github.felyphenrique.tracker.application.audities.events.AuditiesSessionsListener;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component()
public class AuditiesSessionInterceptor implements HandlerInterceptor {
    private final ApplicationContext contextApplication;

    @Autowired()
    public AuditiesSessionInterceptor(ApplicationContext contextApplication) {
        this.contextApplication = contextApplication;
    }

    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler) throws Exception {
        final AuditiesSessionsListener.Event event = new AuditiesSessionsListener.Event(
                handler, request.getRequestedSessionId());
        this.contextApplication.publishEvent(event);
        return true;
    }
}
