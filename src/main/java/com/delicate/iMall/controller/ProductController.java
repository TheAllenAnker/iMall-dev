package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/query")
    public String findProductById(String productId) {
        Product product = productService.findProductById(productId);
        return JSONObject.toJSONString(product);
    }
}
