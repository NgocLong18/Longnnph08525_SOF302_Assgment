package com.sample.service;

import com.sample.model.Departs;
import com.sample.responsitory.DepartsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartsServiceImpl implements DepartsService {
    @Autowired //giúp gọi đối tượng customerrepository đx đc khai báo @Bean trên applicationConfig
    private DepartsResponsitory departsResponsitory;
    @Override
    public List<Departs> findAll() {
        return departsResponsitory.findAll();
    }

    @Override
    public Departs findById(Long id) {
        return null;
    }

    @Override
    public void save(Departs model) {
        departsResponsitory.save(model);
    }

    @Override
    public void remove(Long id) {

    }
}
