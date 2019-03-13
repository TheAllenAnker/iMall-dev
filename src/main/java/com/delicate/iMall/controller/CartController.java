package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Cart;
import com.delicate.iMall.bean.CartItem;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.CartItemVO;
import com.delicate.iMall.service.CartService;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private Sid sid;

    @PostMapping(path = "/addCartItem")
    public JSONResult addCartItem(String userId, String productId) {
        Cart cart = cartService.findCartByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setId(sid.nextShort().substring(0, 8));
            cart.setUserId(userId);
            cart.setPrice(0);
            cartService.addCart(cart);
        }

        CartItem cartItem = cartService.findCartItemById(cart.getId(), productId);
        Product product = productService.findProductById(productId);
        if (cartItem != null) {
            cartItem.setCount(cartItem.getCount() + 1);
            cartService.updateCartItemInfo(cartItem);
        } else {
            cartItem = new CartItem();
            cartItem.setId(sid.nextShort().substring(0, 8));
            cartItem.setProductId(productId);
            cartItem.setCount(1);
            cartItem.setPrice(product.getPrice());
            cartService.addCartItem(cartItem);
        }

        return JSONResult.ok();
    }

    @PostMapping(path = "/deleteCartItem")
    public JSONResult deleteCartItem(String userId, String productId) {
        Cart cart = cartService.findCartByUserId(userId);
        if (cart != null) {
            cartService.deleteCartItemById(cart.getId(), productId);
        }

        return JSONResult.ok();
    }

    @PostMapping(path = "/updateCartItemInfo")
    public JSONResult updateCartItemInfo(String userId, String productId, int count, float price) {
        Cart cart = cartService.findCartByUserId(userId);
        if (cart != null) {
            CartItem cartItem = cartService.findCartItemById(cart.getId(), productId);

            cartItem.setCount(count);
            cartItem.setPrice(price);
            cartService.updateCartItemInfo(cartItem);
        }

        return JSONResult.ok();
    }

    @PostMapping(path = "/getCartItems")
    public JSONResult getCartItemsByUserId(String userId) {
        Cart cart = cartService.findCartByUserId(userId);
        List<CartItemVO> cartItemVOs = new ArrayList<>();
        if (cart != null) {
            List<CartItem> cartItemList = cartService.getAllCartItemsByCartId(cart.getId());
            for (CartItem cartItem : cartItemList) {
                CartItemVO vo = new CartItemVO();
                vo.setCartItem(cartItem);
                vo.setProduct(productService.findProductById(cartItem.getProductId()));
                cartItemVOs.add(vo);
            }
        }

        return JSONResult.ok(JSONObject.toJSONString(cartItemVOs));
    }
}
