package com.example.hieuntph23322.service;

import com.example.hieuntph23322.entity.Manufacturer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ManufacturerService {
    Page<Manufacturer> getPage(Integer pagNo, Integer size);

    List<Manufacturer> getAll();

    void addManufacturer(Manufacturer manufacturer);

    Manufacturer updateManufacturer(Manufacturer manufacturer);

    void removeManufacturer(Integer id);

    Manufacturer findById(Integer id);


}
