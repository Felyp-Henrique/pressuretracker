package com.github.felyphenrique.tracker.infrastructure.migrations;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.github.felyphenrique.tracker.domain.entities.User;
import com.github.felyphenrique.tracker.domain.repositories.UsersRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class SeedsConfiguration {
    private final UsersRepository usersRepository;

    @Autowired
    public SeedsConfiguration(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostConstruct
    @Order(value = 1)
    public void feedUsers() {
        final ArrayList<String> roles = new ArrayList<>();
        final User userAdmin = new User();
        roles.add(User.ROLE_ADMIN);
        userAdmin.setId(1);
        userAdmin.setEmail("admin@tracker.io");
        userAdmin.setUsername("admin");
        userAdmin.setPassword("$2y$10$WTpImslLykp4QzXANA.XY.ebFR1FpcYli/SIt9khL1SIY.v2kE5Ha");
        userAdmin.setRoles(roles);
        if (!this.usersRepository.exists(userAdmin)) {
            this.usersRepository.create(userAdmin);
        }
    }
}
