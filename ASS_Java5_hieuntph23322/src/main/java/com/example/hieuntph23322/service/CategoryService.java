package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Page<Category> getPage(Integer pageNo, Integer size);

    List<Category> getAll();

    void addCategory(Category category);

    Category updateCategory(Category category);

    void removeCategory(Integer id);

    Category findById(Integer id);
}
