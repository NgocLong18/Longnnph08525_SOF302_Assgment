package com.sample.service;

import com.sample.model.Records;
import com.sample.responsitory.RecordsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecordsServiceImpl implements RecordsService {
    @Autowired //giúp gọi đối tượng customerrepository đx đc khai báo @Bean trên applicationConfig
    private RecordsResponsitory recordsResponsitory;
    @Override
    public List<Records> findAll() {
        return recordsResponsitory.findAll();
    }

    @Override
    public Records findById(Long id) {
        return null;
    }

    @Override
    public void save(Records records) {
        recordsResponsitory.save(records);
    }

    @Override
    public void remove(Long id) {

    }
}
