package com.delicate.iMall.service;

import com.delicate.iMall.bean.Product;

import java.util.List;

public interface ProductService {
    Product findProductById(String productId);

    void addProduct(Product product);

    void deleteProductByProductId(String productId);

    void updateProductInfo(Product product);

    List<Product> getProductsByCategoryName(String categoryName);

    List<Product> getAllProducts();
}
