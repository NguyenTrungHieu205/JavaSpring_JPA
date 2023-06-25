package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Capacity;
import com.example.hieuntph23322.entity.Color;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CapacityService {

    List<Capacity> getList();

    Page<Capacity> getAll(Integer pageNo, Integer size);

    void addCapacity(Capacity capacity);

    Capacity updateCapacity(Capacity capacity);

    void removeCapacity(Integer id);

    Capacity findById(Integer id);
}
