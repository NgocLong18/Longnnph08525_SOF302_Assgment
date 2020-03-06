package com.sample.service;

import com.sample.model.Staffs;

import java.util.List;

public interface StaffsService {
    List<Staffs> findAll();

    Staffs findById(Long id);

    void save(Staffs staffs);

    void remove(Long id);

    List<Staffs> findStaffByID(String id);

}
