package com.sample.responsitory;

import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface Responsitory <T,String> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);

    void update(Long id, T model);

}

