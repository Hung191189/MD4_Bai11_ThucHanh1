package com.example.md4_bai11_thuchanh1.controller;

import com.example.md4_bai11_thuchanh1.model.Customers;
import com.example.md4_bai11_thuchanh1.service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    @Autowired
    ICustomersService customersService;

    @GetMapping("")
    public ResponseEntity<Iterable<Customers>> findAllCustomer(){
        List<Customers> customersList = (List<Customers>) customersService.findAll();
        if(customersList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customers> findCustomerById(@PathVariable Long id){
        Optional<Customers> optionalCustomers = customersService.findById(id);
        if(!optionalCustomers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customers){
        return new ResponseEntity<>(customersService.save(customers),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers customers){
        Optional<Customers> optionalCustomers = customersService.findById(id);
        if(!optionalCustomers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customers.setId(optionalCustomers.get().getId());
        return new ResponseEntity<>(customersService.save(customers), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable Long id){
        Optional<Customers> optionalCustomers = customersService.findById(id);
        if(!optionalCustomers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customersService.remove(id);
        return new ResponseEntity<>(optionalCustomers.get(), HttpStatus.OK);
    }
}
