package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Color;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ColorService {
    Page<Color> getPage(Integer pageNo, Integer size);

    List<Color> getAll();

    void addColor(Color color);

    Color updateColor(Color color);

    void remove(Integer id);

    Color findById(Integer id);
}
