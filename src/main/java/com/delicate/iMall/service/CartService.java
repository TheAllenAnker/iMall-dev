package com.delicate.iMall.service;

import com.delicate.iMall.bean.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getAllCartItemsByUserId(String userId);

    void addCartItem(CartItem cartItem);

    void deleteCartItem(CartItem cartItem);

    void updateCartItemInfo(CartItem cartItem);
}
