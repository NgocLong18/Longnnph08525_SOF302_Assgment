package com.sample.service;

import com.sample.model.Users;
import com.sample.responsitory.UsersResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    @Autowired //giúp gọi đối tượng customerrepository đx đc khai báo @Bean trên applicationConfig
    private UsersResponsitory usersResponsitory;
    @Override
    public List<Users> findAll() {
        return usersResponsitory.findAll();
    }


    @Override
    public Users findById(Long id) {
        return null;
    }

    @Override
    public void save(Users users) {
        usersResponsitory.save(users);

    }

    @Override
    public void remove(Long id) {

    }
}
