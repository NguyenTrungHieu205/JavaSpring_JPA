package com.example.hieuntph23322.service.impl;

import com.example.hieuntph23322.service.CartViewModelService;
import com.example.hieuntph23322.viewModel.CartViewModel;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class CartViewModelServiceImpl implements CartViewModelService {
    Map<Integer, CartViewModel> modelMap = new HashMap<>();

    @Override
    public void addCart(CartViewModel item) {
        CartViewModel cartModel = modelMap.get(item.getId());
        if (cartModel == null) {
            modelMap.put(item.getId(), item);
        } else {
            cartModel.setNumber(cartModel.getNumber() + 1);
        }
    }

    @Override
    public Collection<CartViewModel> getAll() {
        return modelMap.values();
    }
}
