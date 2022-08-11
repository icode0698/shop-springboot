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
    @GetMapping({"/details","/details.html"})
    public String detailsPage(){
        return "details";
    }
    @GetMapping({"/message","/message.html"})
    public String messagePage(){
        return "message";
    }
}
