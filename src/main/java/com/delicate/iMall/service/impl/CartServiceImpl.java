package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.Cart;
import com.delicate.iMall.bean.CartItem;
import com.delicate.iMall.dao.CartDao;
import com.delicate.iMall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public List<CartItem> getAllCartItemsByCartId(String cartId) {
        return cartDao.getAllCartItemsByCartId(cartId);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        cartDao.addCartItem(cartItem);
    }

    @Override
    public void deleteCartItemById(String productId, String cartId) {
        cartDao.deleteCartItemById(productId, cartId);
    }

    @Override
    public void updateCartItemInfo(CartItem cartItem) {
        cartDao.updateCartItemInfo(cartItem);
    }

    @Override
    public void addCart(Cart cart) {
        cartDao.addCart(cart);
    }

    @Override
    public Cart findCartByUserId(String userId) {
        return cartDao.findCartByUserId(userId);
    }

    @Override
    public CartItem findCartItemById(String cartId, String productId) {
        return cartDao.findCartItemById(cartId, productId);
    }
}
