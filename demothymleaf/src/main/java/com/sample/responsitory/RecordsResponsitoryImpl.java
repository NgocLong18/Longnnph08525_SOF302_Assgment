package com.sample.responsitory;

import com.sample.model.Departs;
import com.sample.model.Records;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class RecordsResponsitoryImpl implements RecordsResponsitory {
    @PersistenceContext //tạo và xóa các entity, tìm kiếm entity, truy vấn entity
    private EntityManager entityManager;

    @Override
    public List<Records> findAll() {
        String query = "select r from Records r";
        TypedQuery<Records> recordsTypedQuery = entityManager.createQuery(query, Records.class);
        return recordsTypedQuery.getResultList();
    }

    @Override
    public Records findById(Long id) {
        return null;
    }

    @Override
    public void save(Records model) {
        if (model.getRecordId() != null) {
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
    public void update(Long id, Records model) {

    }
}
