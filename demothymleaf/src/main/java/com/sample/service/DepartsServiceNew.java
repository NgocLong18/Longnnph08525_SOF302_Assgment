package com.sample.service;

import com.sample.model.Departs;

import java.util.Optional;

public interface DepartsServiceNew {
    Iterable<Departs> findAll();

    Optional<Departs> findById(Long id);

    void save(Departs departs);

    void remove(Long id);
}
