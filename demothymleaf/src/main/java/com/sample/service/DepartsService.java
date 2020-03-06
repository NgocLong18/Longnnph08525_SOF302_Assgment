package com.sample.service;

import com.sample.model.Departs;

import java.util.List;

public interface DepartsService {
    List<Departs> findAll();

    Departs findById(Long id);

    void save(Departs departs);

    void remove(Long id);
}
