package com.github.felyphenrique.tracker.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.felyphenrique.tracker.domain.entities.User;
import com.github.felyphenrique.tracker.domain.repositories.UsersRepository;

@Repository
public interface DataBaseUsersRepository extends UsersRepository, JpaRepository<User, Integer> {

    @Override
    public User findByUsername(@Param("username") String username);

    @Override
    default public User create(User user) {
        return this.save(user);
    }
}
