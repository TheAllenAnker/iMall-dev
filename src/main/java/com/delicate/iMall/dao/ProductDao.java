package com.delicate.iMall.dao;

import com.delicate.iMall.bean.Product;

import java.util.List;

public interface ProductDao {
    Product findProductById(String productId);

    List<Product> getNewProducts();

    void addProduct(Product product);

    void deleteProductByProductId(String productId);

    void updateProductInfo(Product product);
}
