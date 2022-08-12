package com.newboot.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.CommonResult;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestParam HashMap map, HttpServletRequest request){
        JSONObject json = new JSONObject(map);
        logger.debug(json.toString());
        String message = userService.login(json);
        if(StringUtils.equals(ResultMessage.LOGIN_SUCCESS.getMessage(), message)){
            HttpSession session = request.getSession();
            session.setAttribute("user", json.getString("user"));
            return CommonResult.success(message, json);
        }
        else{
            return CommonResult.failed(message);
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonResult logout(@RequestParam HashMap map, HttpServletRequest request){
        JSONObject json = new JSONObject(map);
        json.put("user",request.getSession().getAttribute("user"));
        userService.logout(json);
        request.getSession().removeAttribute("user");
        return CommonResult.success();
    }

    @RequestMapping("/status")
    @ResponseBody
    public CommonResult status(HttpServletRequest request){
        logger.info("-----------------get status----------------");
        if(ObjectUtils.isEmpty(request.getSession().getAttribute("user"))){
            return CommonResult.failed(ResultMessage.UNAUTHORIZED.getMessage());
        }
        else{
            return CommonResult.success(ResultMessage.LOGIN_USER_ONLINE.getMessage(), userService.getInfo(request.getSession().getAttribute("user").toString()));
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public CommonResult register(@RequestParam HashMap map){
        JSONObject json = new JSONObject(map);
        String message = userService.register(json);
        if(StringUtils.equals(ResultMessage.REGISTER_SUCCESS.getMessage(), message)){
            return CommonResult.success(message);
        }
        else{
            return CommonResult.failed(message);
        }
    }

    @RequestMapping("/comment")
    @ResponseBody
    public CommonResult comment(@RequestParam HashMap map, HttpServletRequest request){
        if(ObjectUtils.isEmpty(request.getSession().getAttribute("user"))){
            return CommonResult.failed(ResultMessage.UNAUTHORIZED.getMessage());
        }
        map.put("user",request.getSession().getAttribute("user"));
        if(userService.comment(map)<1){
            return CommonResult.failed(ResultMessage.COMMENT_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.COMMENT_SUCCESS.getMessage());
    }

    @RequestMapping("/message")
    @ResponseBody
    public CommonResult message(@RequestParam HashMap map, HttpServletRequest request){
        if(ObjectUtils.isEmpty(request.getSession().getAttribute("user"))){
            return CommonResult.failed(ResultMessage.UNAUTHORIZED.getMessage());
        }
        map.put("user", request.getSession().getAttribute("user"));
        if(userService.message(map)<1){
            return CommonResult.failed(ResultMessage.MESSAGE_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.MESSAGE_SUCCESS.getMessage());
    }

    @RequestMapping("/info")
    @ResponseBody
    public CommonResult info(HttpServletRequest request){
        return CommonResult.success(userService.getInfo(request.getSession().getAttribute("user").toString()));
    }

    @RequestMapping("/info/update")
    @ResponseBody
    public CommonResult updateInfo(@RequestParam HashMap map, HttpServletRequest request){
        map.put("user", request.getSession().getAttribute("user"));
        if(userService.updateInfo(map)<1){
            return CommonResult.failed(ResultMessage.LOGIN_ERROR_PASSWORD.getMessage());
        }
        return CommonResult.success();
    }
}
