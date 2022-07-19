package com.newboot.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping({"/","/index","/index.html"})
    public String indexPage(){
        return "index";
    }
    @GetMapping({"/login","/login.html"})
    public String loginPage(){
        return "login";
    }
    @GetMapping({"/register","/register.html"})
    public String registerPage(){
        return "register";
    }
}
