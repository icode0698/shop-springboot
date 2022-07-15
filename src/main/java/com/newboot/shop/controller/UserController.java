package com.newboot.shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.CommonResult;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public CommonResult userLogin(@RequestParam Map map){
        JSONObject json = new JSONObject(map);
        logger.info(map.toString());
        String message = userService.login(json);
        if(StringUtils.equals(ResultMessage.LOGIN_SUCCESS.getMessage(),message)){
            return CommonResult.success(message);
        }
        else{
            return CommonResult.failed(message);
        }
    }
}
