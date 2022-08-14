package com.newboot.shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    @GetMapping({"/","/login","/login.html"})
    public String loginPage(){
        return "login";
    }
    @GetMapping({"/admin","/admin.html"})
    public String adminPage(){
        return "admin";
    }
    @GetMapping({"/home/control","/home/control.html"})
    public String controlPage(){
        return "/home/control";
    }
}
