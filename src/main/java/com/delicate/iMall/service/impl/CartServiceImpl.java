package com.delicate.iMall.service.impl;

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
    public void deleteCartItemById(String productId) {
        cartDao.deleteCartItemById(productId);
    }

    @Override
    public void updateCartItemInfo(CartItem cartItem) {
        cartDao.updateCartItemInfo(cartItem);
    }
}
