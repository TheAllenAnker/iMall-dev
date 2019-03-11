package com.delicate.iMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/index")
public class HomeController {

    @GetMapping("/")
    public String adminLoginPage() {
        return "home";
    }
}
