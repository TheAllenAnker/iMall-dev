package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.ProductCategory;
import com.delicate.iMall.bean.User;
import com.delicate.iMall.service.ProductCategoryService;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.service.UserService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        return "redirect:/admin/index";
    }

    @GetMapping("/index")
    public String adminManagePage(Model model) {
        return "index";
    }

    // Product API
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

    // Product Category API
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

    // User API
    @PostMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {
        userService.deleteUserById(userId);
        return JSONResult.ok();
    }
}
