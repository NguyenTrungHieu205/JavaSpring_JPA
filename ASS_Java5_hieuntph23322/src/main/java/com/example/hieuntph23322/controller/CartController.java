package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.ProductDetail;
import com.example.hieuntph23322.service.CartService;
import com.example.hieuntph23322.service.CartViewModelService;
import com.example.hieuntph23322.service.ProductDetailService;
import com.example.hieuntph23322.viewModel.CartViewModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gio-hang/")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private CartViewModelService cartViewModelService;

    @GetMapping("hien-thi")
    public String hienThiCart() {
        return "cart";
    }

    @GetMapping("add-to-cart/{id}")
    public String addToCart(HttpServletRequest request, @PathVariable("id") Integer id) {
        HttpSession session = request.getSession();
        List<CartViewModel> cartDetailList = (List<CartViewModel>) session.getAttribute("cartDetailList");
        if (cartDetailList == null) {
            cartDetailList = new ArrayList<>();
        }
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
        boolean productExists = false;
        for (CartViewModel cartDetail : cartDetailList) {
            if (cartDetail.getId().equals(id)) {
                // Sản phẩm đã tồn tại, tăng số lượng
                cartDetail.setNumber(cartDetail.getNumber() + 1);
                productExists = true;
                break;
            }
        }
        if (!productExists) {
            // Sản phẩm chưa tồn tại trong giỏ hàng, thêm mới
            ProductDetail productDetail = productDetailService.findById(id);
            if (productDetail != null) {
                CartViewModel newCartDetail = new CartViewModel();
                newCartDetail.setId(id);
                newCartDetail.setName(productDetail.getName());
                newCartDetail.setImages(productDetail.getImages());
                newCartDetail.setNumber(1); // Đặt số lượng ban đầu là 1
                newCartDetail.setUnitPrice(productDetail.getCategory().getProductLine().getPrice());
                cartDetailList.add(newCartDetail);
            }
        }
        session.setAttribute("cartDetailList", cartDetailList);
        session.setAttribute("myCartNum", cartDetailList.size());
        return "cart";
    }

    @GetMapping("removeall")
    public String hienThi(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("cartDetailList");
        session.removeAttribute("myCartNum");
        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String deleteRow(@PathVariable("id") Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<CartViewModel> cartDetailList = (List<CartViewModel>) session.getAttribute("cartDetailList");
        // Xử lý xóa dòng dựa trên ID
        for (CartViewModel x : cartDetailList) {
            if (x.getId() == id) {
                cartDetailList.remove(x);
                break;
            }
        }
        session.setAttribute("cartDetailList", cartDetailList);
        session.setAttribute("myCartNum", cartDetailList.size());
        return "redirect:/gio-hang/hien-thi";
    }


}
