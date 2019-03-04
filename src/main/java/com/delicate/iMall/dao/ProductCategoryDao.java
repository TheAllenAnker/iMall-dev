package com.delicate.iMall.dao;

import com.delicate.iMall.bean.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryDao {
    List<ProductCategory> getAllProductCategories();

    void addProductCategory(ProductCategory productCategory);

    void deleteProductCategoryByName(String categoryName);

    void updateProductCategoryInfo(ProductCategory productCategory);

    ProductCategory getProductCategoryByName(String categoryName);
}
