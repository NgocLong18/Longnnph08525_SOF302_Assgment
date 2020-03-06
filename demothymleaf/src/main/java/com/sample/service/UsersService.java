package com.sample.service;

import com.sample.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();

    Users findById(Long id);

    void save(Users users);

    void remove(Long id);
}
