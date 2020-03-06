package com.sample.service;
import com.sample.model.Users;

import java.util.Optional;

public interface UserServiceNew {
    Iterable<Users> findAll();

    Optional<Users> findById(String username);

    void save(Users users);

    void remove(String username);
}
