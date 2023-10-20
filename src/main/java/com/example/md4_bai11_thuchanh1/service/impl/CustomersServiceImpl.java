package com.example.md4_bai11_thuchanh1.service.impl;

import com.example.md4_bai11_thuchanh1.model.Customers;
import com.example.md4_bai11_thuchanh1.repository.ICustomersRepository;
import com.example.md4_bai11_thuchanh1.service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomersServiceImpl implements ICustomersService {
    @Autowired
    private ICustomersRepository customersRepository;
    @Override
    public Iterable<Customers> findAll() {
        return customersRepository.findAll();
    }

    @Override
    public Optional<Customers> findById(Long id) {
        return customersRepository.findById(id);
    }

    @Override
    public Customers save(Customers customers) {
      return customersRepository.save(customers);
    }

    @Override
    public void remove(Long id) {
        customersRepository.deleteById(id);
    }
}
