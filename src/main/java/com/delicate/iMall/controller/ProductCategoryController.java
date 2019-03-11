package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.ProductCategory;
import com.delicate.iMall.service.ProductCategoryService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private Sid sid;

    @RequestMapping("/allCategories")
    public String getAllCategories() {
        List<ProductCategory> categories = productCategoryService.getAllProductCategories();
        return JSONObject.toJSONString(categories);
    }

    @PostMapping("/addCategory")
    public JSONResult addProductCategory(String prodCateJsonString) {
        ProductCategory productCategory = JSONObject.parseObject(prodCateJsonString, ProductCategory.class);
        productCategory.setId(sid.nextShort().substring(0, 8));
        productCategoryService.addProductCategory(productCategory);
        return JSONResult.ok();
    }

    @PostMapping("/deleteCategory")
    public JSONResult deleteProductCategoryByName(String categoryName) {
        productCategoryService.deleteProductCategoryByName(categoryName);
        return JSONResult.ok();
    }

    @PostMapping("/updateProdCateInfo")
    public JSONResult updateProductCategoryInfo(String prodCateJsonString) {
        ProductCategory productCategory = JSONObject.parseObject(prodCateJsonString, ProductCategory.class);
        productCategoryService.updateProductCategoryInfo(productCategory);
        return JSONResult.ok();
    }
}
