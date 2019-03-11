package com.delicate.iMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.delicate.iMall.bean.Cart;
import com.delicate.iMall.bean.CartItem;
import com.delicate.iMall.bean.Product;
import com.delicate.iMall.bean.vo.CartItemVO;
import com.delicate.iMall.service.CartService;
import com.delicate.iMall.service.ProductService;
import com.delicate.iMall.utils.JSONResult;
import com.delicate.iMall.utils.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        CartItem cartItem = new CartItem();
        Cart cart = cartService.findCartByUserId(userId);
        Product product = productService.findProductById(productId);
        if (cart == null) {
            cart = new Cart();
            cart.setId(sid.nextShort().substring(0, 8));
            cart.setUserId(userId);
            cart.setPrice(0);
            cartService.addCart(cart);
        }

        cartItem.setId(sid.nextShort().substring(0, 8));
        cartItem.setCartId(cart.getId());
        cartItem.setProductId(productId);
        cartItem.setCount(1);
        cartItem.setPrice(product.getPrice());
        cartService.addCartItem(cartItem);

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
        List<CartItemVO> cartItemVOs = null;
        if (cart != null) {

        }

        return JSONResult.ok(JSONObject.toJSONString(cartItemVOs));
    }
}
