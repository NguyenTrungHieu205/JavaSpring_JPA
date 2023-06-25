package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Customer;
import com.example.hieuntph23322.repository.CustomerRepository;
import com.example.hieuntph23322.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIpml implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> getPage(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customer.setId(customer.getId());
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getID(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
}
