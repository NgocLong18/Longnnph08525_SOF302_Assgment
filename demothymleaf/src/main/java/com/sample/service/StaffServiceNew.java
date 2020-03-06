package com.sample.service;

import com.sample.model.Staffs;

import java.util.Optional;

public interface StaffServiceNew {
    Iterable<Staffs> findAll();

    Optional<Staffs> findById(Long id);

    void save(Staffs staffs);

    void remove(Long id);

}
