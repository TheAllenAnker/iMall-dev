package com.delicate.iMall.bean;

public class CartItemVO {
    private CartItem cartItem;
    private Product product;

    public CartItemVO() {
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}