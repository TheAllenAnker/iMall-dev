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
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/addProductPage")
    public String addProductPage() {
        return "addProducts";
    }

    @GetMapping("/addCategoryPage")
    public String addCategoryPage() {
        return "addCategory";
    }

    @GetMapping("/categoryPage")
    public String categoryPage(Model model) {
        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
        model.addAttribute("productCategories", productCategories);
        return "category";
    }

    @GetMapping("/productListPage")
    public String productListPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    // Product API
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("productName") String productName, @RequestParam("categoryId") String categoryId, @RequestParam("description") String description, @RequestParam("inventory") int inventory,
                             @RequestParam("cover") MultipartFile cover, @RequestParam("price") float price) {
        try {
            Product product = new Product();
            product.setId(sid.nextShort());
            product.setProductName(productName);
            product.setCategoryId(categoryId);
            product.setDescription(description);
            product.setInventory(inventory);
            product.setCover(uploadImage(cover));
            product.setPrice(price);
            product.setStatus(0);
            productService.addProduct(product);
            return "redirect:/admin/productListPage";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
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
    public String addProductCategory(@RequestParam("level") int level, @RequestParam("name") String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(sid.nextShort().substring(0, 8));
        productCategory.setLevel(level);
        productCategory.setName(name);
        productCategory.setStatus(0);
        productCategoryService.addProductCategory(productCategory);
        return "redirect:/admin/categoryPage";
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

    @PostMapping("/updateUseInfo")
    public JSONResult updateUserInfo(String infoJSONString) {
        User user = JSONObject.parseObject(infoJSONString, User.class);
        userService.updateUserInfo(user);
        return JSONResult.ok(user);
    }

    public String uploadImage(MultipartFile image) throws IOException {
        // 七牛云默认外链
        final String QINIU_UPLOAD_URL = "http://pnu0mosmq.bkt.clouddn.com/";
        //方法一 获取相对应的流
        InputStream stream = image.getInputStream();
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "4uyEuvP8g2_iqoyZFdKQ5umqMJdLPduSbonVbfev";
        String secretKey = "gHtwzohBxs_lVZaL0mvQKIEATnp_hIOw9usm4xoG";
        String bucket = "imall";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString().replaceAll("\\-", "");

        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(stream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                // System.out.println(putRet.hash);
                return QINIU_UPLOAD_URL + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                return "fail";
            }
        } catch (Exception ex) {
            return "fail";
        }
    }
}
