package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.BillProduct;
import com.example.hieuntph23322.service.BillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("hoa-don")
public class BillProductController {
    @Autowired
    private BillProductService billProductService;

    @GetMapping("hien-thi")
    public String hienThiHoaDon(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, Model model) {
        Page<BillProduct> billProducts = billProductService.getPage(pageNo, 8);
        model.addAttribute("billProduct", billProducts.getContent());
        model.addAttribute("billProductPage", billProducts);
        return "quanLyHoaDon";
    }

    @GetMapping("search")
    public String search(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                         @RequestParam(value = "searchPhoneNumber", required = false) String phoneNumber, Model model) {
        List<BillProduct> billProduct = billProductService.search(phoneNumber);
        model.addAttribute("billProduct", billProduct);
//        model.addAttribute("billProductPage", billProduct);
        return "viewSearch";
    }
}
