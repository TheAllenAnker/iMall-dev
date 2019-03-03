package com.delicate.iMall.service;

import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    void addProductCategory(Product product);

    void deleteProductCategoryByName(String categoryName);

    void updateProductCategoryInfo(ProductCategory productCategory);
}
