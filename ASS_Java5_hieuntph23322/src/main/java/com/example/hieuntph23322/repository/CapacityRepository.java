package com.example.hieuntph23322.repository;

import com.example.hieuntph23322.entity.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacityRepository extends JpaRepository<Capacity, Integer> {
}
