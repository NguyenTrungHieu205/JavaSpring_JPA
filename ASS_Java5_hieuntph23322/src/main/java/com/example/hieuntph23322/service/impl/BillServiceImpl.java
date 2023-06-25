package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Bill;
import com.example.hieuntph23322.repository.BillRepository;
import com.example.hieuntph23322.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public void addBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill findById(Integer id) {
        return billRepository.findById(id).orElse(null);
    }
}
