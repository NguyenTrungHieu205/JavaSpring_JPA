package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Color;
import com.example.hieuntph23322.entity.ProductLine;
import com.example.hieuntph23322.repository.ProductLineRepository;
import com.example.hieuntph23322.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductLineServiceIpml implements ProductLineService {
    @Autowired
    private ProductLineRepository productLineRepository;

    @Override
    public Page<ProductLine> getPage(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return productLineRepository.findAll(pageable);
    }

    @Override
    public List<ProductLine> getAll() {
        return productLineRepository.findAll();
    }

    @Override
    public void addProductLine(ProductLine productLine) {
        productLine.setDateCreate(new Date());
        productLine.setDateCorrect(new Date());
        productLineRepository.save(productLine);
    }

    @Override
    public void updateProductLine(ProductLine productLine) {
        productLine.setId(productLine.getId());

        ProductLine productLineID = findById(productLine.getId());
        productLine.setDateCreate(productLineID.getDateCreate());
        productLine.setDateCorrect(new Date());
        productLineRepository.save(productLine);
    }

    @Override
    public void removeProductLine(Integer id) {
        productLineRepository.deleteById(id);
    }

    @Override
    public ProductLine findById(Integer id) {
        return productLineRepository.findById(id).orElse(null);
    }
}
