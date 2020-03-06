package com.sample.responsitory;

import com.sample.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class UsersResponsitoryImpl implements UsersResponsitory {
    @PersistenceContext //tạo và xóa các entity, tìm kiếm entity, truy vấn entity
    private EntityManager entityManager;
    @Override
    public List<Users> findAll() {
        String query = "select u from Users u";
        TypedQuery<Users> usersTypedQuery = entityManager.createQuery(query, Users.class);
        return usersTypedQuery.getResultList();
    }

    @Override
    public Users findById(Long id) {
        return null;
    }

    @Override
    public void save(Users model) {
            entityManager.persist(model);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(Long id, Users model) {

    }
}
