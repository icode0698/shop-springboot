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
    @GetMapping({"/select/selectbrand","/select/selectbrand.html"})
    public String selectBrandPage(){
        return "/select/selectbrand";
    }
    @GetMapping({"/select/selectspu","/select/selectspu.html"})
    public String selectSpuPage(){
        return "/select/selectspu";
    }
    @GetMapping({"/select/selectsku","/select/selectsku.html"})
    public String selectSkuPage(){
        return "/select/selectsku";
    }
    @GetMapping({"/select/selectorder","/select/selectorder.html"})
    public String selectOrderPage(){
        return "/select/selectorder";
    }
    @GetMapping({"/select/selectvalue","/select/selectvalue.html"})
    public String selectValuePage(){
        return "/select/selectvalue";
    }
    @GetMapping({"/update/updatebrand","/update/updatebrand.html"})
    public String updateBrandPage(){
        return "/update/updatebrand";
    }
    @GetMapping({"/update/updatespu","/update/updatespu.html"})
    public String updateSpuPage(){
        return "/update/updatespu";
    }
    @GetMapping({"/update/updatesku","/update/updatesku.html"})
    public String updateSkuPage(){
        return "/update/updatesku";
    }
    @GetMapping({"/update/updatevalue","/update/updatevalue.html"})
    public String updateValuePage(){
        return "/update/updatevalue";
    }
    @GetMapping({"/insert/insertbrand","/insert/insertbrand.html"})
    public String insertBrandPage(){
        return "/insert/insertbrand";
    }
    @GetMapping({"/insert/insertspu","/insert/insertspu.html"})
    public String insertSpuPage(){
        return "/insert/insertspu";
    }
    @GetMapping({"/insert/insertprice","/insert/insertprice.html"})
    public String insertPricePage(){
        return "/insert/insertprice";
    }
    @GetMapping({"/insert/insertvalue","/insert/insertvalue.html"})
    public String insertValuePage(){
        return "/insert/insertvalue";
    }
    @GetMapping({"/delete/deletespu","/delete/deletespu.html"})
    public String deleteSpuPage(){
        return "/delete/deletespu";
    }
}
