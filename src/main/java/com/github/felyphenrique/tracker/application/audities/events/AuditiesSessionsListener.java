package com.github.felyphenrique.tracker.application.audities.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component()
public class AuditiesSessionsListener implements ApplicationListener<AuditiesSessionsListener.Event> {
    private final Logger logger;

    public AuditiesSessionsListener() {
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public void onApplicationEvent(@NonNull Event event) {
        final String loggerMessage = "Session access from '%s' with id '%s'"
                .formatted(event.getSource().getClass().getName(), event.getSessionId());
        this.logger.info(loggerMessage);
    }

    public static final class Event extends ApplicationEvent {
        private String sessionId;

        public Event(Object source, String sessionId) {
            super(source);
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}
