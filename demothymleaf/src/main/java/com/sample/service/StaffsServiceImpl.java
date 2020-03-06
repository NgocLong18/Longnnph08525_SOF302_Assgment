package com.sample.service;

import com.sample.model.Staffs;
import com.sample.responsitory.DepartsResponsitory;
import com.sample.responsitory.StaffsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class StaffsServiceImpl implements StaffsService {
    @Autowired //giúp gọi đối tượng customerrepository đx đc khai báo @Bean trên applicationConfig
    private StaffsResponsitory staffsResponsitory;

    @PersistenceContext //tạo và xóa các entity, tìm kiếm entity, truy vấn entity
    private EntityManager entityManager;

    @Override
    public List<Staffs> findAll() {
        return staffsResponsitory.findAll();
    }

    @Override
    public Staffs findById(Long id) {
        return staffsResponsitory.findById(id);
    }

    @Override
    public void save(Staffs staffs) {
        staffsResponsitory.save(staffs);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Staffs> findStaffByID(String id) {
            String query = "select s from Staffs s where s.staffId = ' " + id + "'";
            TypedQuery<Staffs> staffsTypedQuery = entityManager.createQuery(query, Staffs.class);
            return staffsTypedQuery.getResultList();
        }
    }



