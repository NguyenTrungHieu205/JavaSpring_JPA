package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Bill;
import com.example.hieuntph23322.entity.BillProduct;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BillProductService {

    void addBillProduct(BillProduct billProduct);

    Page<BillProduct> getPage(Integer pageNo, Integer size);

    List<BillProduct> search(String phoneNumber);

}
