package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Capacity;
import com.example.hieuntph23322.entity.Category;
import com.example.hieuntph23322.entity.Color;
import com.example.hieuntph23322.entity.ProductLine;
import com.example.hieuntph23322.service.CapacityService;
import com.example.hieuntph23322.service.CategoryService;
import com.example.hieuntph23322.service.ColorService;
import com.example.hieuntph23322.service.ProductLineService;
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
@RequestMapping("/phan-loai-hang/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private CapacityService capacityService;
    @Autowired
    private ProductLineService productLineService;

    @GetMapping("hien-thi")
    public String hienThiCategory(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Category> categoryList = categoryService.getPage(pageNo, 5);
        model.addAttribute("phanLoai", categoryList.getContent());
        model.addAttribute("phanLoaiPage", categoryList);
        model.addAttribute("phanHang", new Category());
        //hien thi color
        List<Color> colorList = colorService.getAll();
        model.addAttribute("color", colorList);
        //hien thi capacity
        List<Capacity> capacityList = capacityService.getList();
        model.addAttribute("capacity", capacityList);
        //hien thi productLine
        List<ProductLine> productLineList = productLineService.getAll();
        model.addAttribute("productLine", productLineList);
        return "category";
    }

    @PostMapping("add")
    public String addCategory(@Valid @ModelAttribute("phanHang") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<Category> categoryList = categoryService.getPage(0, 5);
            model.addAttribute("phanLoai", categoryList.getContent());
            model.addAttribute("phanLoaiPage", categoryList);
            //hien thi color
            List<Color> colorList = colorService.getAll();
            model.addAttribute("color", colorList);
            //hien thi capacity
            List<Capacity> capacityList = capacityService.getList();
            model.addAttribute("capacity", capacityList);
            //hien thi productLine
            List<ProductLine> productLineList = productLineService.getAll();
            model.addAttribute("productLine", productLineList);
            return "category";
        }
        categoryService.addCategory(category);
        return "redirect:/phan-loai-hang/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeCategory(@PathVariable("id") Integer id) {
        categoryService.removeCategory(id);
        return "redirect:/phan-loai-hang/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailCategory(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        Category category = categoryService.findById(id);
        redirectAttributes.addFlashAttribute("PHL", category);
        model.addAttribute("phanHang", new Category());
        return "redirect:/phan-loai-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateCategory(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("PHL", category);
        model.addAttribute("phanHang", new Category());
        //hien thi color
        List<Color> colorList = colorService.getAll();
        model.addAttribute("color", colorList);
        //hien thi capacity
        List<Capacity> capacityList = capacityService.getList();
        model.addAttribute("capacity", capacityList);
        //hien thi productLine
        List<ProductLine> productLineList = productLineService.getAll();
        model.addAttribute("productLine", productLineList);
        return "/detail/detail-category";
    }

    @PostMapping("update")
    public String updateCategory(@Valid @ModelAttribute("phanHang") Category category, BindingResult result) {
        categoryService.updateCategory(category);
        return "redirect:/phan-loai-hang/hien-thi";
    }
}
