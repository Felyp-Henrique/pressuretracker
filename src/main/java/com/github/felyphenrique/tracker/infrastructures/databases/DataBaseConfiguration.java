package com.github.felyphenrique.tracker.infrastructures.databases;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://%s:%d/%s".formatted(dataSourceHost, dataSourcePort, dataSourceDataBase))
                .username(dataSourceUsername)
                .password(dataSourcePassword)
                .build();
    }
}
