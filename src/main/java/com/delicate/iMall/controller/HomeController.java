package com.delicate.iMall.controller;

import com.delicate.iMall.bean.Product;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/index")
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/newProducts")
    public JSONResult getNewProducts() {
        List<Product> newProducts = productService.getNewProducts();
        return JSONResult.ok(newProducts);
    }
}
