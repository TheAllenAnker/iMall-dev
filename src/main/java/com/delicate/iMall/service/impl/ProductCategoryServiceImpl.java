package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.ProductCategory;
import com.delicate.iMall.dao.ProductCategoryDao;
import com.delicate.iMall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryDao.getAllProductCategories();
    }

    @Override
    public void addProductCategory(Product product) {
        productCategoryDao.addProductCategory(product);
    }

    @Override
    public void deleteProductCategoryByName(String categoryName) {
        productCategoryDao.deleteProductCategoryByName(categoryName);
    }

    @Override
    public void updateProductCategoryInfo(ProductCategory productCategory) {
        productCategoryDao.updateProductCategoryInfo(productCategory);
    }
}
