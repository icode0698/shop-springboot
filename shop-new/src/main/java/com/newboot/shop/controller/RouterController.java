package com.newboot.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping({"/", "/index", "/index.html"})
    public String indexPage() {
        return "index";
    }

    @GetMapping({"/login", "/login.html"})
    public String loginPage() {
        return "login";
    }

    @GetMapping({"/register", "/register.html"})
    public String registerPage() {
        return "register";
    }

    @GetMapping({"/details", "/details.html"})
    public String detailsPage() {
        return "details";
    }

    @GetMapping({"/message", "/message.html"})
    public String messagePage() {
        return "message";
    }

    @GetMapping({"/personal", "/personal.html"})
    public String personPage() {
        return "personal";
    }

    @GetMapping({"/comment", "/comment.html"})
    public String commentPage() {
        return "comment";
    }

    @GetMapping({"/category", "/category.html"})
    public String categoryPage() {
        return "category";
    }

    @GetMapping({"/search", "/search.html"})
    public String searchPage() {
        return "search";
    }
}
