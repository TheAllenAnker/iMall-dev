package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/query")
    public JSONResult findProductById(String productId) {
        Product product = productService.findProductById(productId);
        return JSONResult.ok(JSONObject.toJSONString(product));
    }

    @PostMapping(value = "/getProducts")
    public JSONResult getProductsByCategoryName(String categoryName) {
        List<Product> products = productService.getProductsByCategoryName(categoryName);
        return JSONResult.ok(JSONObject.toJSONString(products));
    }
}
