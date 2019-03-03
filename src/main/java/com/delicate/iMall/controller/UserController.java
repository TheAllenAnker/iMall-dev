package com.delicate.iMall.controller;

import com.delicate.iMall.bean.User;
import com.delicate.iMall.service.UserService;
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

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    @ResponseBody
    public String home(String username, String password) {
        User user = userService.findUserById("1");
        System.out.println(user);
        return user.toString();
    }
}
