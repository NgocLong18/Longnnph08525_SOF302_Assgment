package com.sample.responsitory;

import com.sample.model.Staffs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class StaffsResponsitoryImpl implements StaffsResponsitory {
    @PersistenceContext //tạo và xóa các entity, tìm kiếm entity, truy vấn entity
    private EntityManager entityManager;

    @Override
    public List<Staffs> findAll() {
        String query = "select s from Staffs s where s.statusOfStaff = '' ";
        TypedQuery<Staffs> staffsTypedQuery = entityManager.createQuery(query, Staffs.class);
        return staffsTypedQuery.getResultList();
    }

    @Override
    public Staffs findById(Long id) {
        String query = "select s from Staffs s where s.staffId = ' " + id + "'";
        TypedQuery<Staffs> staffsTypedQuery = entityManager.createQuery(query, Staffs.class);
        return staffsTypedQuery.getSingleResult();
    }

    @Override
    public void save(Staffs model) {
        if (model.getStaffId() != null) {
            //update
            entityManager.merge(model);
        }else {
            //add new
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(Long id, Staffs model) {

    }

    public List<Staffs> findStaffByID(String id) {
        String query = "select s from Staffs s where s.staffId = ' " + id + "'";
        TypedQuery<Staffs> staffsTypedQuery = entityManager.createQuery(query, Staffs.class);
        return staffsTypedQuery.getResultList();
    }

}
