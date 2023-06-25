package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Customer;
import com.example.hieuntph23322.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/khach-hang/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("hien-thi")
    public String hienThiCustomer(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Customer> customerList = customerService.getPage(pageNo, 5);
        model.addAttribute("custumerGet", customerList.getContent());
        model.addAttribute("custumerGetPage", customerList);
        model.addAttribute("KH", new Customer());
        return "customer";
    }

    @PostMapping("add")
    public String addCustomer(@Valid @ModelAttribute("KH") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<Customer> customerList = customerService.getPage(0, 5);
            model.addAttribute("custumerGet", customerList.getContent());
            model.addAttribute("custumerGetPage", customerList);
            return "customer";
        }
        customerService.addCustomer(customer);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeCustomer(@PathVariable("id") Integer id) {
        customerService.removeCustomer(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailCustomer(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        Customer customer = customerService.getID(id);
        redirectAttributes.addFlashAttribute("KhachHang", customer);
        model.addAttribute("KH", new Customer());
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateCustomer(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.getID(id);
        model.addAttribute("KhachHang", customer);
        model.addAttribute("KH", new Customer());
        return "/detail/detail-customer";
    }

    @PostMapping("update")
    public String updateCustomer(@Valid @ModelAttribute("KH") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "/detail/detail-customer";
        }
        customerService.updateCustomer(customer);
        return "redirect:/khach-hang/hien-thi";
    }
}
