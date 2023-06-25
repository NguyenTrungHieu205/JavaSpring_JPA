package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.ProductDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductDetailService {
    Page<ProductDetail> getPage(Integer pageNo, Integer size);

    List<ProductDetail> getAll();

    void addProductDetail(ProductDetail productDetail);

    void updateProductDetail(ProductDetail productDetail);

    void removeProductDetail(Integer id);

    ProductDetail findById(Integer id);
}
