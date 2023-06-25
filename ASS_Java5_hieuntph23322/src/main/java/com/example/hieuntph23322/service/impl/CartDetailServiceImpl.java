package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.CartDetail;
import com.example.hieuntph23322.repository.CartDetailRepository;
import com.example.hieuntph23322.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public void addCartDetail(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }
}
