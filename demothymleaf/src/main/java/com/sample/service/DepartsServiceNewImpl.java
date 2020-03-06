package com.sample.service;

import com.sample.model.Departs;
import com.sample.responsitory.DepartsRepositoryNew;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DepartsServiceNewImpl implements DepartsServiceNew {
    @Autowired
    private DepartsRepositoryNew departsRepositoryNew;
    @Override
    public Iterable<Departs> findAll() {
        return departsRepositoryNew.findAll();
    }

    @Override
    public Optional<Departs> findById(Long id) {
        return departsRepositoryNew.findById(id);
    }

    @Override
    public void save(Departs departs) {
        departsRepositoryNew.save(departs);
    }

    @Override
    public void remove(Long id) {
        departsRepositoryNew.deleteById(id);
    }
}
