package com.github.felyphenrique.tracker.infrastructures.internationalization;

import java.util.Locale;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration()
public class LocaleConfiguration {

    @Bean()
    public LocaleResolver i18nLocaleResolver() {
        return new ParameterLocaleResolver();
    }

    public static final class ParameterLocaleResolver implements LocaleResolver {
        private final Logger logger;

        public ParameterLocaleResolver() {
            this.logger = LoggerFactory.getLogger(getClass());
        }

        @Override
        public @NonNull Locale resolveLocale(@NonNull HttpServletRequest request) {
            this.logger.info(request.getContextPath());
            final String language = Objects.toString(request.getParameter("lang"), "pt-br");
            final Locale locale = Locale.forLanguageTag(language);
            return locale;
        }

        @Override
        public void setLocale(
                @NonNull HttpServletRequest request,
                @Nullable HttpServletResponse response,
                @Nullable Locale locale) {
            /* não necessário implementar */
        }
    }
}
