package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.ProductLine;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductLineService {
    Page<ProductLine> getPage(Integer pageNo, Integer size);

    List<ProductLine> getAll();

    void addProductLine(ProductLine productLine);

    void updateProductLine(ProductLine productLine);

    void removeProductLine(Integer id);

    ProductLine findById(Integer id);
}
