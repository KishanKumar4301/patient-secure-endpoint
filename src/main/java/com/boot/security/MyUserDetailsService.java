package com.boot.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        // In real-time, fetch from DB
        return new User("admin", "{noop}password", Collections.emptyList());
    }
}
