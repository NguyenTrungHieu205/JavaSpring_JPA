package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Bill;
import com.example.hieuntph23322.entity.BillProduct;
import com.example.hieuntph23322.entity.Customer;
import com.example.hieuntph23322.entity.ProductDetail;
import com.example.hieuntph23322.service.BillProductService;
import com.example.hieuntph23322.service.BillService;
import com.example.hieuntph23322.service.CustomerService;
import com.example.hieuntph23322.service.ProductDetailService;
import com.example.hieuntph23322.viewModel.CartViewModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/gio-hang/")
public class SellController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private BillProductService billProductService;

    //MUA TRONG GIỎ HÀNG
    @GetMapping("/gio-hang/xac-nhan")
    public String hienThiXacNhan() {
        return "billThanhToan";
    }

    @GetMapping("/gio-hang/xac-nhan-thanh-toan")
    public String hienThiThanhToan(Model model, @RequestParam("tenKhachHang") String tenKhachHang,
                                   @RequestParam("soDienThoai") String soDienThoai,
                                   @RequestParam("diaChi") String diaChi) {
        model.addAttribute("tenKhachHang", tenKhachHang);
        model.addAttribute("soDienThoai", soDienThoai);
        model.addAttribute("diaChi", diaChi);
        return "thanhToan";
    }

    @PostMapping("/gio-hang/thanh-toan")
    public String thanhToanGioHang(HttpServletRequest request, Model model, @RequestParam("tenKhachHang") String tenKhachHang,
                                   @RequestParam("soDienThoai") String soDienThoai,
                                   @RequestParam("diaChi") String diaChi) {
        //tạo mới khách hàng
        Customer customer = new Customer();
        customer.setCode(soDienThoai);
        customer.setFullName(tenKhachHang);
        customer.setPhoneNumber(soDienThoai);
        customer.setAdrress(diaChi);
        customerService.addCustomer(customer);

        //Tạo hóa đơn mới
        Bill bill = new Bill();
        bill.setCode(soDienThoai);
        bill.setPurchaseDate(java.time.LocalDate.now());
        bill.setPhoneNumber(soDienThoai);
        bill.setAddress(diaChi);
        bill.setStatus(0);
        bill.setCustomer(customerService.getID(customer.getId()));
        billService.addBill(bill);

        HttpSession session = request.getSession();
        List<CartViewModel> cartDetailList = (List<CartViewModel>) session.getAttribute("cartDetailList");

        for (int i = 0; i < cartDetailList.size(); i++) {
            BillProduct billProduct = new BillProduct();
            billProduct.setNumber(cartDetailList.get(i).getNumber());
            billProduct.setUnitPrice(cartDetailList.get(i).getUnitPrice());
            billProduct.setAmount((cartDetailList.get(i).getNumber()) * (cartDetailList.get(i).getUnitPrice()));
            billProduct.setProductDetail(productDetailService.findById(cartDetailList.get(i).getId()));
            billProduct.setBill(billService.findById(bill.getId()));
            billProductService.addBillProduct(billProduct);
        }
//        cartDetailList.removeAll();

        session.setAttribute("cartDetailList", cartDetailList);
        model.addAttribute("maHD", bill.getCode());
        model.addAttribute("ngayDat", bill.getPurchaseDate());
//        model.addAttribute("tongTien", cartDetailList.get().getNumber() * cartDetailList.get().getUnitPrice());

        session.removeAttribute("myCartNum");
//        session.removeAttribute("cartDetailList");
        return "endThanhToan";


    }

    //NÚT MUA NGAY
    @GetMapping("/mua-ngay/xac-nhan/{id}")
    public String hienThiXacNhanMuaNgay(@PathVariable("id") Integer id, Model model) {
        ProductDetail cartDetailList = productDetailService.findById(id);
        model.addAttribute("chiTietSanPham", cartDetailList);
        return "buyNowProduct";
    }

    @PostMapping("/mua-ngay/thanh-toan/{id}")
    public String thanhToanGioHangMuaNgay(@PathVariable("id") Integer id, HttpServletRequest request, Model model, @RequestParam("tenKhachHang") String tenKhachHang,
                                          @RequestParam("soDienThoai") String soDienThoai,
                                          @RequestParam("diaChi") String diaChi) {
        //tạo mới khách hàng
        Customer customer = new Customer();
        customer.setCode(soDienThoai);
        customer.setFullName(tenKhachHang);
        customer.setPhoneNumber(soDienThoai);
        customer.setAdrress(diaChi);
        customerService.addCustomer(customer);

        //Tạo hóa đơn mới
        Bill bill = new Bill();
        bill.setCode(soDienThoai);
        bill.setPurchaseDate(java.time.LocalDate.now());
        bill.setPhoneNumber(soDienThoai);
        bill.setAddress(diaChi);
        bill.setStatus(0);
        bill.setCustomer(customerService.getID(customer.getId()));
        billService.addBill(bill);

        ProductDetail cartDetailList = productDetailService.findById(id);
        BillProduct billProduct = new BillProduct();
        billProduct.setNumber(1);
        billProduct.setUnitPrice(cartDetailList.getCategory().getProductLine().getPrice());
        billProduct.setAmount((cartDetailList.getNumber()) * (cartDetailList.getCategory().getProductLine().getPrice()));
        billProduct.setProductDetail(productDetailService.findById(cartDetailList.getId()));
        billProduct.setBill(billService.findById(bill.getId()));
        billProductService.addBillProduct(billProduct);

//        cartDetailList.removeAll();

        model.addAttribute("cartDetailList", cartDetailList);
        model.addAttribute("maHD", bill.getCode());
        model.addAttribute("ngayDat", bill.getPurchaseDate());
        model.addAttribute("tongTien", billProduct.getAmount());
        model.addAttribute("img", cartDetailList.getImages());
//        session.removeAttribute("cartDetailList");
//        return "redirect:/trangChu";
        return "endThanhToanBuyNow";

    }
}
