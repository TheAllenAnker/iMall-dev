package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.ProductCategory;
import com.delicate.iMall.dao.ProductCategoryDao;
import com.delicate.iMall.dao.ProductDao;
import com.delicate.iMall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public Product findProductById(String productId) {
        return productDao.findProductById(productId);
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void deleteProductByProductId(String productId) {
        productDao.deleteProductByProductId(productId);
    }

    @Override
    public void updateProductInfo(Product product) {
        productDao.updateProductInfo(product);
    }

    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        ProductCategory category = productCategoryDao.getProductCategoryByName(categoryName);
        return category == null ? null : productDao.getProductsByCategoryId(category.getId()) ;
    }
}
