package com.sample.responsitory;

import com.sample.model.Departs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class DepartsResponsitoryImpl implements DepartsResponsitory {
    @PersistenceContext //tạo và xóa các entity, tìm kiếm entity, truy vấn entity
    private EntityManager entityManager;

    @Override
    public List<Departs> findAll() {
        String query = "select d from Departs d";
        TypedQuery<Departs> departsTypedQuery = entityManager.createQuery(query, Departs.class);
        return departsTypedQuery.getResultList();
    }

    @Override
    public Departs findById(Long id) {
        return null;
    }

    @Override
    public void save(Departs model) {
        if (model.getDepartID() != null) {
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
    public void update(Long id, Departs model) {
        entityManager.merge(model);
    }
}
