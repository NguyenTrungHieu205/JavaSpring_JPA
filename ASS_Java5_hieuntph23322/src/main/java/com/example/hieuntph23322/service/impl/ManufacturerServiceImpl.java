package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Color;
import com.example.hieuntph23322.entity.Manufacturer;
import com.example.hieuntph23322.repository.ManufacturerRepository;
import com.example.hieuntph23322.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Page<Manufacturer> getPage(Integer pagNo, Integer size) {
        Pageable pageable = PageRequest.of(pagNo, size);
        return manufacturerRepository.findAll(pageable);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturer.setDateCreate(new Date());
        manufacturer.setDateCorrect(new Date());
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        manufacturer.setId(manufacturer.getId());

        Manufacturer manufacturerID = findById(manufacturer.getId());
        manufacturer.setDateCreate(manufacturerID.getDateCreate());
        manufacturer.setDateCorrect(new Date());
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public void removeManufacturer(Integer id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public Manufacturer findById(Integer id) {
        return manufacturerRepository.findById(id).orElse(null);
    }
}
