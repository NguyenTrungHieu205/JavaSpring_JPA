package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Manufacturer;
import com.example.hieuntph23322.entity.ProductLine;
import com.example.hieuntph23322.service.ManufacturerService;
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
@RequestMapping("/dong-san-pham/")
public class ProductLineController {
    @Autowired
    private ProductLineService productLineService;
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("hien-thi")
    public String hienThiProductLine(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<ProductLine> productLineList = productLineService.getPage(pageNo, 5);
        model.addAttribute("product", productLineList.getContent());
        model.addAttribute("productPage", productLineList);
        model.addAttribute("pro", new ProductLine());
        //hien thi id len combox
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        model.addAttribute("manu", manufacturerList);
        return "productLine";
    }

    @PostMapping("add")
    public String addProductLine(@Valid @ModelAttribute("pro") ProductLine productLine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<ProductLine> productLineList = productLineService.getPage(0, 5);
            model.addAttribute("product", productLineList.getContent());
            model.addAttribute("productPage", productLineList);
            //hien thi id len combox
            List<Manufacturer> manufacturerList = manufacturerService.getAll();
            model.addAttribute("manu", manufacturerList);
            return "productLine";
        }
        productLineService.addProductLine(productLine);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeProductLine(@PathVariable("id") Integer id) {
        productLineService.removeProductLine(id);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailProductLine(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        ProductLine productLine = productLineService.findById(id);
        redirectAttributes.addFlashAttribute("proLine", productLine);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateProductLine(@PathVariable("id") Integer id, Model model) {
        ProductLine productLine = productLineService.findById(id);
        model.addAttribute("proLine", productLine);
        model.addAttribute("pro", new ProductLine());
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        model.addAttribute("manu", manufacturerList);
        return "detail/detail-productLine";
    }

    @PostMapping("update")
    public String updateProductLine(@Valid @ModelAttribute("pro") ProductLine productLine, BindingResult result, Model model) {
//        if(result.hasErrors()){
//            Page<ProductLine> productLineList = productLineService.getPage(0, 5);
//            model.addAttribute("product", productLineList.getContent());
//            model.addAttribute("productPage", productLineList);
//            //hien thi id len combox
//            List<Manufacturer> manufacturerList = manufacturerService.getAll();
//            model.addAttribute("manu", manufacturerList);
//            return "detail/detail-productLine";
//        }
        productLineService.updateProductLine(productLine);
        return "redirect:/dong-san-pham/hien-thi";
    }
}
