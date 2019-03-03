package com.delicate.iMall.dao;

import com.delicate.iMall.bean.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {
    List<CartItem> getAllCartItemsByCartId(String cartId);

    void addCartItem(CartItem cartItem);

    void deleteCartItemById(String productId);

    void updateCartItemInfo(CartItem cartItem);
}
