package com.example.md4_bai11_thuchanh1.service;

import com.example.md4_bai11_thuchanh1.model.Customers;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
