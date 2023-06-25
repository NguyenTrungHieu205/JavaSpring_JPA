package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Manufacturer;
import com.example.hieuntph23322.service.ManufacturerService;
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
@RequestMapping("/hang-san-pham/")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    private List<Manufacturer> manufacturerList = new ArrayList<>();

    @GetMapping("hien-thi")
    public String getAllData(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Manufacturer> manufacturerList = manufacturerService.getPage(pageNo, 5);
        model.addAttribute("manufacturerList", manufacturerList.getContent());
        model.addAttribute("manufacturerPage", manufacturerList);
        model.addAttribute("manufac", new Manufacturer());
        return "manufacturer";
    }

    @PostMapping("add")
    public String addManufacturer(@Valid @ModelAttribute("manufac") Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<Manufacturer> manufacturerList = manufacturerService.getPage(0, 5);
            model.addAttribute("manufacturerList", manufacturerList.getContent());
            model.addAttribute("manufacturerPage", manufacturerList);
            return "manufacturer";
        }
        manufacturerService.addManufacturer(manufacturer);
        return "redirect:/hang-san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailManufacturer(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        redirectAttributes.addFlashAttribute("manu", manufacturer);
        return "redirect:/hang-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeManufacturer(@PathVariable("id") Integer id) {
        manufacturerService.removeManufacturer(id);
        return "redirect:/hang-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateManufacturer(Model model, @PathVariable("id") Integer id) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        model.addAttribute("manu", manufacturer);
        model.addAttribute("manufac", new Manufacturer());
        return "detail/detail-manufacturer";
    }

    @PostMapping("update")
    public String updateManufacturer(@Valid @ModelAttribute("manufac") Manufacturer manufacturer, BindingResult result) {
        if (result.hasErrors()) {
            return "detail/detail-manufacturer";
        }
        manufacturerService.updateManufacturer(manufacturer);
        return "redirect:/hang-san-pham/hien-thi";
    }


}
