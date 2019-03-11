package com.delicate.iMall.service;

import com.delicate.iMall.bean.Cart;
import com.delicate.iMall.bean.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getAllCartItemsByCartId(String cartId);

    void addCartItem(CartItem cartItem);

    void deleteCartItemById(String productId, String cartId);

    void updateCartItemInfo(CartItem cartItem);

    void addCart(Cart cart);

    Cart findCartByUserId (String userId);

    CartItem findCartItemById(String cartId, String productId);
}
