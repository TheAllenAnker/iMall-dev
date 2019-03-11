package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;

    @Autowired
    private Sid sid;

    @PostMapping("/login")
    public JSONResult login(String username, String password) {
        return JSONResult.ok();
    }

    @PostMapping("/logout")
    public JSONResult logout() {
        return JSONResult.ok();
    }

    @PostMapping("/addProduct")
    public JSONResult addProduct(@RequestBody Product product) {
        product.setId(sid.nextShort());
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
