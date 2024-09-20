package com.github.felyphenrique.tracker.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.felyphenrique.tracker.domain.repositories.UsersRepository;

@Service
public class TrackerUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Autowired
    public TrackerUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.usersRepository.findByUsername(username);
    }
}
