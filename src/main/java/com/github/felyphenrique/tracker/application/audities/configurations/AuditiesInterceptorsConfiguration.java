package com.github.felyphenrique.tracker.application.audities.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.github.felyphenrique.tracker.application.audities.interceptors.AuditiesSessionInterceptor;

@Configuration()
public class AuditiesInterceptorsConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(new AuditiesSessionInterceptor(getApplicationContext()))
                .addPathPatterns("/**");
    }
}
