package com.delicate.iMall.service;

import com.delicate.iMall.bean.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    void addProductCategory(ProductCategory productCategory);

    void deleteProductCategoryByName(String categoryName);

    void updateProductCategoryInfo(ProductCategory productCategory);
}
