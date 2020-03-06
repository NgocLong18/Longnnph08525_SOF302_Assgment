package com.sample.service;

import com.sample.model.Users;
import com.sample.responsitory.UserReponsitoryNew;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceNewImpl implements UserServiceNew {
    @Autowired
    private UserReponsitoryNew userReponsitoryNew;
    @Override
    public Iterable<Users> findAll() {
        return userReponsitoryNew.findAll();
    }

    @Override
    public Optional<Users> findById(String username) {
        return userReponsitoryNew.findById(username);
    }

    @Override
    public void save(Users users) {
        userReponsitoryNew.save(users);
    }

    @Override
    public void remove(String username) {

    }
}
