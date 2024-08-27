package com.github.felyphenrique.tracker.infrastructures.internationalization;

import java.util.Locale;
import java.util.Objects;

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
    public LocaleResolver localeResolver() {
        return new ParameterLocaleResolver();
    }

    public static final class ParameterLocaleResolver implements LocaleResolver {

        @Override
        public @NonNull Locale resolveLocale(@NonNull HttpServletRequest request) {
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
