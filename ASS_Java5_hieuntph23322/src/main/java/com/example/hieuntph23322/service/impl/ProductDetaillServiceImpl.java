package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.ProductDetail;
import com.example.hieuntph23322.repository.ProductDetailRepository;
import com.example.hieuntph23322.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetaillServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public Page<ProductDetail> getPage(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return productDetailRepository.findAll(pageable);
    }

    @Override
    public List<ProductDetail> getAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public void addProductDetail(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void updateProductDetail(ProductDetail productDetail) {
        productDetail.setId(productDetail.getId());
        productDetailRepository.save(productDetail);
    }

    @Override
    public void removeProductDetail(Integer id) {
        productDetailRepository.deleteById(id);
    }

    @Override
    public ProductDetail findById(Integer id) {
        return productDetailRepository.findById(id).orElse(null);
    }
}
