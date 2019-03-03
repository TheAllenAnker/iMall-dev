package com.delicate.iMall.dao;

import com.delicate.iMall.bean.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {
    List<CartItem> getAllCartItemsByUserId(String userId);

    void addCartItem(CartItem cartItem);

    void deleteCartItem(CartItem cartItem);

    void updateCartItemInfo(CartItem cartItem);
}
