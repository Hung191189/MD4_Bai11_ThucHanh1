package com.example.md4_bai11_thuchanh1.repository;

import com.example.md4_bai11_thuchanh1.model.Customers;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomersRepository extends PagingAndSortingRepository<Customers, Long> {
}
