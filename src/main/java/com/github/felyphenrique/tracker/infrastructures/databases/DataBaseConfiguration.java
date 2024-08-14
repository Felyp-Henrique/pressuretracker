package com.github.felyphenrique.tracker.infrastructures.databases;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactory;

@Configuration()
public class DataBaseConfiguration {

    @Value("${spring.datasource.host}")
    private String dataSourceHost;

    @Value("${spring.datasource.port}")
    private int dataSourcePort;

    @Value("${spring.datasource.database}")
    private String dataSourceDataBase;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean()
    public ConnectionFactory trackerConnectionFactory() {
        return new MariadbConnectionFactory(
                MariadbConnectionConfiguration.builder()
                        .host(dataSourceHost)
                        .port(dataSourcePort)
                        .database(dataSourceDataBase)
                        .username(dataSourceUsername)
                        .password(dataSourcePassword)
                        .build());
    }

    @Bean()
    public DatabaseClient trackerDatabaseClient(ConnectionFactory factory) {
        return DatabaseClient.builder()
                .connectionFactory(factory)
                .build();
    }
}
