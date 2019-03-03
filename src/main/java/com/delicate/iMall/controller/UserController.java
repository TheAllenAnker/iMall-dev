package com.delicate.iMall.controller;

import com.delicate.iMall.bean.Admin;
import com.delicate.iMall.bean.User;
import com.delicate.iMall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        User user = userService.findUserById("1");
        adminService.findAdminById("1");
        cartService.getAllCartItemsByCartId("1");
        orderService.getOrdersByUserId("1");
        productCategoryService.getAllProductCategories();
        productService.getNewProducts();
        userAddressService.getAddressesByUserId("1");
        System.out.println(user);
        return user == null ? "Null" : user.toString();
    }
}
