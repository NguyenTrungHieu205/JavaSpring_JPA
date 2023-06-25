package com.example.hieuntph23322.controller;

import com.example.hieuntph23322.entity.Category;
import com.example.hieuntph23322.entity.ProductDetail;
import com.example.hieuntph23322.repository.ProductDetailRepository;
import com.example.hieuntph23322.service.CategoryService;
import com.example.hieuntph23322.service.ProductDetailService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chi-tiet-san-pham/")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private CategoryService categoryService;

    private List<ProductDetail> productDetailList = new ArrayList<>();

    public static final String URL = "F:/FPT_Poly_HocTap/JAVA5_SOF3021/ASS_Java5_hieuntph23322/src/main/webapp/assets/";

    @GetMapping("hien-thi")
    public String hienThiProductDetail(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<ProductDetail> productDetailList = productDetailService.getPage(pageNo, 5);
        model.addAttribute("productDetail", productDetailList.getContent());
        model.addAttribute("productDetailPage", productDetailList);
        model.addAttribute("chiTiet", new ProductDetail());
        //hien thi category
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("category", categoryList);
        return "product-detail";
    }

    //    @Valid @ModelAttribute("chiTiet") ProductDetail productDetail,
//    BindingResult result,
//                   Model model,
    @PostMapping("add")
    public String addProductDetail(@RequestParam("images") MultipartFile multipartFile,
                                   @RequestParam("code") String code,
                                   @RequestParam("name") String name,
                                   @RequestParam("status") Integer status,
                                   @RequestParam("number") Integer number,
                                   @RequestParam("category") Category category
    ) throws IOException {
//        if (result.hasErrors()) {
//            productDetailList = productDetailService.getAll();
//            model.addAttribute("productDetail", productDetailList);
//            return "product-detail";
//        }
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(URL, multipartFile.getOriginalFilename());
        fileNames.append(multipartFile.getOriginalFilename());
        Files.write(fileNameAndPath, multipartFile.getBytes());

        ProductDetail productDetail = new ProductDetail();
        productDetail.setCode(code);
        productDetail.setName(name);
        productDetail.setStatus(status);
        productDetail.setNumber(number);
        productDetail.setCategory(category);
        productDetail.setImages(fileNames.toString());
        productDetailService.addProductDetail(productDetail);
//        }
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeProductDetail(@PathVariable("id") Integer id) {
        productDetailService.removeProductDetail(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailProductDetail(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        ProductDetail productDetail = productDetailService.findById(id);
        redirectAttributes.addFlashAttribute("ProDetail", productDetail);
//        model.addAttribute("chiTiet", new ProductDetail());
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateProductDetail(@PathVariable("id") Integer id, Model model) {
        ProductDetail productDetail = productDetailService.findById(id);
        model.addAttribute("ProDetail", productDetail);
        model.addAttribute("chiTiet", new ProductDetail());
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("category", categoryList);
        return "/detail/detail-product-detail";
    }

    @PostMapping("update")
    public String updateProductDetail(@Valid @ModelAttribute("chiTiet") ProductDetail productDetail, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/detail/detail-product-detail";
        }
        productDetailService.updateProductDetail(productDetail);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
}
