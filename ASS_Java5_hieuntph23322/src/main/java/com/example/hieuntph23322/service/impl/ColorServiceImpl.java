package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Capacity;
import com.example.hieuntph23322.entity.Color;
import com.example.hieuntph23322.repository.ColorRepository;
import com.example.hieuntph23322.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorRepository colorRepository;

    @Override
    public Page<Color> getPage(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return colorRepository.findAll(pageable);
    }

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public void addColor(Color color) {
        color.setDateCreate(new Date());
        color.setDateCorrect(new Date());
        colorRepository.save(color);
    }

    @Override
    public Color updateColor(Color color) {
        color.setId(color.getId());

        Color colorID = findById(color.getId());
        color.setDateCreate(colorID.getDateCreate());
        color.setDateCorrect(new Date());
        return colorRepository.save(color);
    }

    @Override
    public void remove(Integer id) {
        colorRepository.deleteById(id);
    }

    @Override
    public Color findById(Integer id) {
        return colorRepository.findById(id).orElse(null);
    }
}
