package com.newboot.shop.admin.controller;

import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/select")
    @ResponseBody
    public CommonResult select(@RequestParam HashMap map) {
        return CommonResult.success(orderService.select(map));
    }
}
