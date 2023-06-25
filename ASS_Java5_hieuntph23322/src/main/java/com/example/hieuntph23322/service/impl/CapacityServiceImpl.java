package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Capacity;
import com.example.hieuntph23322.repository.CapacityRepository;
import com.example.hieuntph23322.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CapacityServiceImpl implements CapacityService {
    @Autowired
    CapacityRepository capacityRepository;

    @Override
    public List<Capacity> getList() {
        return capacityRepository.findAll();
    }

    @Override
    public Page<Capacity> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return capacityRepository.findAll(pageable);
    }

    @Override
    public void addCapacity(Capacity capacity) {
        capacity.setDateCreate(new Date());
        capacity.setDateCorrect(new Date());
        capacityRepository.save(capacity);
    }

    @Override
    public Capacity updateCapacity(Capacity capacity) {
        capacity.setId(capacity.getId());

        Capacity capacityID = findById(capacity.getId());
        capacity.setDateCreate(capacityID.getDateCreate());
        capacity.setDateCorrect(new Date());
        return capacityRepository.save(capacity);
    }

    @Override
    public void removeCapacity(Integer id) {
        capacityRepository.deleteById(id);
    }

    @Override
    public Capacity findById(Integer id) {
        return capacityRepository.findById(id).orElse(null);
    }

}
