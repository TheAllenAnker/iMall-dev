package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.ProductCategory;
import com.delicate.iMall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/allCategories")
    public String getAllCategories() {
        List<ProductCategory> categories = productCategoryService.getAllProductCategories();
        return JSONObject.toJSONString(categories);
    }
}
