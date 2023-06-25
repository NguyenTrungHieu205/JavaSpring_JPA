package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Category;
import com.example.hieuntph23322.repository.CategoryRepository;
import com.example.hieuntph23322.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIpml implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private List<Category> categoryList = new ArrayList<>();

    @Override
    public Page<Category> getPage(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        category.setId(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
