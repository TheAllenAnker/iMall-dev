package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.Product;
import com.delicate.iMall.dao.ProductDao;
import com.delicate.iMall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findProductById(String productId) {
        return productDao.findProductById(productId);
    }

    @Override
    public List<Product> getNewProducts() {
        return productDao.getNewProducts();
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
}