package com.sample.service;

import com.sample.model.Staffs;
import com.sample.responsitory.StaffsRepositoryNew;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StaffsServiceNewImpl implements StaffServiceNew{
    @Autowired
    private StaffsRepositoryNew staffsRepositoryNew;
    @Override
    public Iterable<Staffs> findAll() {
        return staffsRepositoryNew.findAll();
    }

    @Override
    public Optional<Staffs> findById(Long id) {
        return staffsRepositoryNew.findById(id);
    }

    @Override
    public void save(Staffs staffs) {
        staffsRepositoryNew.save(staffs);
    }

    @Override
    public void remove(Long id) {
        staffsRepositoryNew.deleteById(id);

    }
}
