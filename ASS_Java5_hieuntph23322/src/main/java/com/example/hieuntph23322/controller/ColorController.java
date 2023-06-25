package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Color;
import com.example.hieuntph23322.service.ColorService;
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
@RequestMapping("/mau-sac/")
public class ColorController {
    @Autowired
    private ColorService colorService;

    @GetMapping("hien-thi")
    public String hienThiColor(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Color> colorList = colorService.getPage(pageNo, 5);
        model.addAttribute("color", colorList.getContent());
        model.addAttribute("colorPage", colorList);
        model.addAttribute("col", new Color());
        return "color";
    }

    @PostMapping("add")
    public String addColor(@Valid @ModelAttribute("col") Color color, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<Color> colorList = colorService.getPage(0, 5);
            model.addAttribute("color", colorList.getContent());
            model.addAttribute("colorPage", colorList);
            return "color";
        }
        colorService.addColor(color);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeColor(@Valid @PathVariable("id") Integer id) {
        colorService.remove(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailColor(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        Color color = colorService.findById(id);
        redirectAttributes.addFlashAttribute("sac", color);
        model.addAttribute("col", new Color());
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateColor(@PathVariable("id") Integer id, Model model) {
        Color color = colorService.findById(id);
        model.addAttribute("sac", color);
        model.addAttribute("col", new Color());
        return "/detail/detail-color";
    }

    @PostMapping("update")
    public String updateColor(@Valid @ModelAttribute("col") Color color, BindingResult result) {
        if (result.hasErrors()) {
            return "/detail/detail-color";
        }
        colorService.updateColor(color);
        return "redirect:/mau-sac/hien-thi";
    }
}
