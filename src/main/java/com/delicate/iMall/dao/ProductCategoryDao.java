package com.delicate.iMall.dao;

import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryDao {
    List<ProductCategory> getAllProductCategories();

    void addProductCategory(Product product);

    void deleteProductCategoryByName(String categoryName);

    void updateProductCategoryInfo(ProductCategory productCategory);
}
