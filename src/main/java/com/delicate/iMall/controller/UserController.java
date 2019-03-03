package com.delicate.iMall.controller;

import com.delicate.iMall.bean.*;
import com.delicate.iMall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    @ResponseBody
    public String home(String username, String password) {
        User user = userService.findUserById("ASAASAF");
        System.out.println(user);
        user = userService.findUserByUsername("Allen Anker1");
        System.out.println(user);

        Admin admin = adminService.findAdminById("ASDF1");
        System.out.println(admin);
        admin = adminService.findAdminByUsername("username1");
        System.out.println(admin);

        List<CartItem> cartItems = cartService.getAllCartItemsByCartId("CARTID1");
        System.out.println(cartItems);

        List<Order> orders = orderService.getOrdersByUserId("ASADFAF");
        System.out.println(orders);

        List<ProductCategory> categories = productCategoryService.getAllProductCategories();
        System.out.println(categories);

        List<Product> products = productService.getNewProducts();
        System.out.println(products);

        List<UserAddress> addresses = userAddressService.getAddressesByUserId("ASAASAF");
        System.out.println(addresses);

        return user == null ? "Null" : user.toString();
    }
}
