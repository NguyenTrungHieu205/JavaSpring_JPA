package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    Page<Customer> getPage(Integer pageNo, Integer size);

    List<Customer> getAll();

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void removeCustomer(Integer id);

    Customer getID(Integer id);
}
