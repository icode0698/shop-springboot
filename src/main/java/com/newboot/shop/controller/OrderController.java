package com.newboot.shop.controller;

import com.newboot.shop.common.CommonResult;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/join")
    @ResponseBody
    public CommonResult join(@RequestParam HashMap map, HttpServletRequest request){
        map.put("user", request.getSession().getAttribute("user"));
        if(orderService.join(map)<1){
            return CommonResult.failed(ResultMessage.TROLLEY_JOIN_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.TROLLEY_JOIN_SUCCESS.getMessage());
    }

    @RequestMapping("/purchase")
    @ResponseBody
    public CommonResult purchase(@RequestParam HashMap map, HttpServletRequest request){
        map.put("user", request.getSession().getAttribute("user"));
        if(orderService.purchase(map)<1){
            return CommonResult.failed(ResultMessage.PURCHASE_PAY_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.PURCHASE_SUCCESS.getMessage());
    }

    @RequestMapping("/orderinfo")
    @ResponseBody
    public CommonResult orderinfo(@RequestParam HashMap map){
        return CommonResult.success();
    }

    @RequestMapping("/settlement")
    @ResponseBody
    public CommonResult settlement(@RequestParam HashMap map){
        return CommonResult.success();
    }
}
