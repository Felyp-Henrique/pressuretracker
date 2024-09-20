package com.github.felyphenrique.tracker.domain.repositories;

import com.github.felyphenrique.tracker.domain.entities.User;

public interface UsersRepository {
    public User findByUsername(String username);

    public User create(User user);

    public boolean existsById(int id);
}
