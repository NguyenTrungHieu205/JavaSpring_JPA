package com.example.hieuntph23322.repository;

import com.example.hieuntph23322.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
}
