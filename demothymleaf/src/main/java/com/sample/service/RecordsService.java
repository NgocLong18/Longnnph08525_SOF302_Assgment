package com.sample.service;

import com.sample.model.Records;

import java.util.List;

public interface RecordsService {
    List<Records> findAll();

    Records findById(Long id);

    void save(Records records);

    void remove(Long id);
}
