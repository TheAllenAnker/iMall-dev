package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/addProduct")
    public JSONResult addProduct(String prodJsonString) {
        Product product = JSONObject.parseObject(prodJsonString, Product.class);
        productService.addProduct(product);
        return JSONResult.ok();
    }

    @PostMapping("/deleteProduct")
    public JSONResult deleteProductByProductId(String productId) {
        productService.deleteProductByProductId(productId);
        return JSONResult.ok();
    }

    @PostMapping("/updateProductInfo")
    public JSONResult updateProductInfo(String prodJsonString) {
        Product product = JSONObject.parseObject(prodJsonString, Product.class);
        productService.updateProductInfo(product);
        return JSONResult.ok();
    }
}
