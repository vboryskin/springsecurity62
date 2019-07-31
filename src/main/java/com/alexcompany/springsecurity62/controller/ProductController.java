package com.alexcompany.springsecurity62.controller;

import com.alexcompany.springsecurity62.dto.ProductDTO;
import com.alexcompany.springsecurity62.service.MailService;
import com.alexcompany.springsecurity62.service.ProductService;
import com.alexcompany.springsecurity62.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    private final String MESSAGE = "Привіт! Продукт %s за ціною %d вироблений %s успішно додано до нашого сайту! Купи медальку!";

    private int TOTAL = 3;

    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("product", new ProductDTO());
        return "product";
    }

    @GetMapping({"/", "/index"})
    public String index(Model model,
                        @RequestParam(name = "page", required = false, defaultValue = "1") String page,
                        @RequestParam(name = "sort", required = false, defaultValue = "name")String sort){
        model.addAttribute("products", productService.findAll(PageRequest.of(
                Integer.valueOf(page)-1,
                TOTAL,
                Sort.by(sort)
        )));
        return "index";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute(name = "product")ProductDTO product, Principal principal){
        productService.saveNewProduct(product);
        mailService.send("New Product added!",
                userService.findOne(principal.getName()).get().getEmail(),
                String.format(MESSAGE, product.getName(), product.getPrice(), product.getManufacturer()));
        return "redirect:/product";
    }
}
