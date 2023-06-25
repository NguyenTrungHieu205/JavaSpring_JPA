package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Bill;

public interface BillService {
    void addBill(Bill bill);

    Bill findById(Integer id);
}
