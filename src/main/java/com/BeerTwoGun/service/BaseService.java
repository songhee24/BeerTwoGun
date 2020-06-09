package com.BeerTwoGun.service;

import java.util.List;

public interface BaseService<T> {
    T save(T item);

    List<T> findAll();

    T findById(Long id);

    boolean delete(Long id);
}
