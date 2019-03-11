package com.delicate.iMall.bean.vo;

import com.delicate.iMall.bean.Product;

public class CartItemVO {
    private Product product;
    private int count;
    private float price;

    public CartItemVO() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
