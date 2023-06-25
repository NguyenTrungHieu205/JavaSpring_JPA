package com.example.hieuntph23322.viewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartViewModel {
    private List<CartViewModel> cartViewModels = new ArrayList<>();

    private Integer id;
    private String name;
    private Integer number;
    private Float unitPrice;
    private String images;
    private Float amount;
}
