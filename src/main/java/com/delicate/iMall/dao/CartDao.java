package com.delicate.iMall.dao;

import com.delicate.iMall.bean.Cart;
import com.delicate.iMall.bean.CartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {
    List<CartItem> getAllCartItemsByCartId(String cartId);

    void addCartItem(CartItem cartItem);

    void deleteCartItemById(@Param("productId") String productId, @Param("cartId") String cartId);

    void updateCartItemInfo(CartItem cartItem);

    void addCart(Cart cart);

    Cart findCartByUserId(@Param("userId") String userId);

    CartItem findCartItemById(@Param("cartId") String cartId, @Param("productId") String productId);
}
