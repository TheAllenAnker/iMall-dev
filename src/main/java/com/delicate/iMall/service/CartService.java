package com.delicate.iMall.service;

import com.delicate.iMall.bean.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getAllCartItemsByCartId(String cartId);

    void addCartItem(CartItem cartItem);

    void deleteCartItemById(String productId);

    void updateCartItemInfo(CartItem cartItem);
}
