package com.newboot.shop.admin.controller;

import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.common.ResultMessage;
import com.newboot.shop.admin.service.AdminService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestParam HashMap map, HttpServletRequest request){
        if(adminService.login(map)<0){
            return CommonResult.failed(ResultMessage.LOGIN_ERROR_PASSWORD.getMessage());
        }
        request.getSession().setAttribute("admin", map.get("admin"));
        return CommonResult.success();
    }

    @RequestMapping("/status")
    @ResponseBody
    public CommonResult status(HttpServletRequest request){
        if(ObjectUtils.isEmpty(request.getSession().getAttribute("admin"))){
            return CommonResult.failed(ResultMessage.UNAUTHORIZED.getMessage());
        }
        return CommonResult.success(request.getSession().getAttribute("admin"));
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonResult logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return CommonResult.success();
    }

    @RequestMapping("/boinfo")
    @ResponseBody
    public CommonResult boinfo(){
        return CommonResult.success(adminService.getBoInfo());
    }

    @RequestMapping("/control")
    @ResponseBody
    public CommonResult control(@RequestParam HashMap map){
        if(ObjectUtils.isEmpty(map.get("type"))){
            return CommonResult.failed(ResultMessage.PAGE_DATA_ERROR.getMessage());
        }
        return CommonResult.success(adminService.getControl(map));
    }
    @RequestMapping("/offline")
    @ResponseBody
    public CommonResult offline(@RequestParam HashMap map){
        adminService.offline(map);
        return CommonResult.success(ResultMessage.LOGIN_USER_OFFLINE.getMessage());
    }
}
