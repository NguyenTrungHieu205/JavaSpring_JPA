package com.example.hieuntph23322.service;

import com.example.hieuntph23322.viewModel.CartViewModel;

import java.util.Collection;

public interface CartViewModelService {
    void addCart(CartViewModel item);

    Collection<CartViewModel> getAll();

}
