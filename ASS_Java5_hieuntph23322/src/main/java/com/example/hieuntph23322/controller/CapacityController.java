package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Capacity;
import com.example.hieuntph23322.service.CapacityService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dung-luong/")
public class CapacityController {
    @Autowired
    private CapacityService capacityService;


    @GetMapping("hien-thi")
    public String hienThiCapicity(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Capacity> capacities = capacityService.getAll(pageNo, 5);
        model.addAttribute("capacity", capacities.getContent());
        model.addAttribute("pageDungLuong", capacities);
        model.addAttribute("cap", new Capacity());
        return "capacity";
    }

    @PostMapping("add")
    public String addCapicity(@Valid @ModelAttribute("cap") Capacity capacity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<Capacity> capacities = capacityService.getAll(0, 5);
            model.addAttribute("capacity", capacities.getContent());
            model.addAttribute("pageDungLuong", capacities);
            return "capacity";
        }
        capacityService.addCapacity(capacity);
        return "redirect:/dung-luong/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeCapacity(@Valid @PathVariable("id") Integer id) {
        capacityService.removeCapacity(id);
        return "redirect:/dung-luong/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailColor(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        Capacity capacity = capacityService.findById(id);
        redirectAttributes.addFlashAttribute("city", capacity);
        model.addAttribute("cap", new Capacity());
        return "redirect:/dung-luong/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateColor(@PathVariable("id") Integer id, Model model) {
        Capacity capacity = capacityService.findById(id);
        model.addAttribute("city", capacity);
        model.addAttribute("cap", new Capacity());
        return "/detail/detail-capacity";
    }

    @PostMapping("update")
    public String updateColor(@Valid @ModelAttribute("col") Capacity capacity, BindingResult result) {
        if (result.hasErrors()) {
            return "/detail/detail-capacity";
        }
        capacityService.updateCapacity(capacity);
        return "redirect:/dung-luong/hien-thi";
    }
}
