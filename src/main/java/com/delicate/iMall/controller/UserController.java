package com.delicate.iMall.controller;

import com.delicate.iMall.service.UserService;
import com.delicate.iMall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JSONResult login(String username, String password) {
        // 查询数据库用户名和密码是否匹配（通过用户名查询获取一个 User 对象，获取其密码对比输入的 password MD5 加密后是否一致）
        return JSONResult.ok();
    }

    @PostMapping("/register")
    public JSONResult register(String username, String password) {
        // 新建一个 User 对象并初始化其数据加入数据库中，此前需要查询用户名是否已经存在
        return JSONResult.ok();
    }

    @PostMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {
        userService.deleteUserById(userId);
        return JSONResult.ok();
    }


    /*

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
    */
}
