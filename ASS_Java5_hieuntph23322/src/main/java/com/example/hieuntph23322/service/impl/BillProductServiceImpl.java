package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.BillProduct;
import com.example.hieuntph23322.repository.BillProductRepository;
import com.example.hieuntph23322.service.BillProductService;
import com.example.hieuntph23322.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillProductServiceImpl implements BillProductService {
    @Autowired
    private BillProductRepository billProductRepository;

    @Override
    public void addBillProduct(BillProduct billProduct) {
        billProductRepository.save(billProduct);
    }

    @Override
    public Page<BillProduct> getPage(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return billProductRepository.findAll(pageable);
    }

    @Override
    public List<BillProduct> search(String phoneNumber) {
//        Pageable pageable = PageRequest.of(pageNo - 1, size);
//        Page<BillProduct> billProductPage = Page.empty();
//        if(phoneNumber != null){
        List<BillProduct> billProducts = billProductRepository.searchPhoneNumber(phoneNumber);
//        }
        return billProducts;
    }
}
