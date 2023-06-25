package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.entity.Cart;
import com.example.hieuntph23322.repository.CartRepository;
import com.example.hieuntph23322.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }
}
