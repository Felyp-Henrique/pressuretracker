package com.github.felyphenrique.tracker.domain.repositories;

import com.github.felyphenrique.tracker.domain.entities.User;

public interface UsersRepository {

    public User findByUsername(String username);

    public User create(User user);

    public User update(User user);

    public boolean exists(User user);
}
