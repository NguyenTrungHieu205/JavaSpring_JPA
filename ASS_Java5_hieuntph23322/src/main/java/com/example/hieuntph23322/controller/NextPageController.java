package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.ProductDetail;
import com.example.hieuntph23322.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NextPageController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/trang-cua-toi")
    public String hienThiTrangCuaToi() {
        return "TrangCuaToi";
    }

    @GetMapping("/login")
    public String hienThiLogin() {
        return "login";
    }

    @GetMapping("/view-chi-tiet-san-pham")
    public String viewChiTietSanPham(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<ProductDetail> productDetailList = productDetailService.getPage(pageNo, 6);
        model.addAttribute("chiTietSanPham", productDetailList.getContent());
        model.addAttribute("chiTietSanPhamPage", productDetailList);
        return "viewSanPhamBH";
    }

    @GetMapping("/trang-chu")
    public String hienThiTrangChu(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<ProductDetail> productDetailList = productDetailService.getPage(pageNo, 6);
        model.addAttribute("chiTietSanPham", productDetailList.getContent());
        model.addAttribute("chiTietSanPhamPage", productDetailList);
        return "trangChu";
    }

}
