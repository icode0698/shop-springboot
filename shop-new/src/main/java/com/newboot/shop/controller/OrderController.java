package com.newboot.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.CommonResult;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.service.OrderService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public CommonResult join(@RequestParam HashMap map, HttpServletRequest request) {
        map.put("user", request.getSession().getAttribute("user"));
        if (orderService.join(map) < 1) {
            return CommonResult.failed(ResultMessage.TROLLEY_JOIN_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.TROLLEY_JOIN_SUCCESS.getMessage());
    }

    @RequestMapping("/purchase")
    @ResponseBody
    public CommonResult purchase(@RequestParam HashMap map, HttpServletRequest request) {
        map.put("user", request.getSession().getAttribute("user"));
        if (orderService.purchase(map) < 1) {
            return CommonResult.failed(ResultMessage.PURCHASE_PAY_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.PURCHASE_SUCCESS.getMessage());
    }

    @RequestMapping("/trolleyList")
    @ResponseBody
    public CommonResult trolleyList(@RequestParam HashMap map, HttpServletRequest request) {
        if (ObjectUtils.isEmpty(request.getSession().getAttribute("user"))) {
            return CommonResult.failed(ResultMessage.UNAUTHORIZED.getMessage());
        }
        map.put("user", request.getSession().getAttribute("user"));
        return CommonResult.success(orderService.getTrolleyList(map));
    }

    @RequestMapping("/orderList")
    @ResponseBody
    public CommonResult orderList(@RequestParam HashMap map, HttpServletRequest request) {
        if (ObjectUtils.isEmpty(request.getSession().getAttribute("user"))) {
            return CommonResult.failed(ResultMessage.UNAUTHORIZED.getMessage());
        }
        map.put("user", request.getSession().getAttribute("user"));
        return CommonResult.success(orderService.getOrderList(map));
    }

    @RequestMapping("/trolley/settlement")
    @ResponseBody
    public CommonResult trolleySettlement(@RequestBody JSONObject map) {
        if (orderService.trolleySettlement(map) < 0) {
            return CommonResult.failed(ResultMessage.PAGE_DATA_ERROR.getMessage());
        }
        return CommonResult.success(ResultMessage.PURCHASE_SUCCESS.getMessage());
    }

    @RequestMapping("/trolley/delete")
    @ResponseBody
    public CommonResult trolleyDelete(@RequestParam HashMap map, HttpServletRequest request) {
        map.put("user", request.getSession().getAttribute("user"));
        if (orderService.trolleyDelete(map) < 1) {
            return CommonResult.failed();
        }
        return CommonResult.success(ResultMessage.ORDER_TROLLEY_DELETE.getMessage());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public CommonResult delete(@RequestParam HashMap map, HttpServletRequest request) {
        map.put("user", request.getSession().getAttribute("user"));
        if (orderService.delete(map) < 1) {
            return CommonResult.failed();
        }
        return CommonResult.success(ResultMessage.ORDER_DELETE.getMessage());
    }

    @RequestMapping("/info")
    @ResponseBody
    public CommonResult info(@RequestParam HashMap map, HttpServletRequest request) {
        map.put("user", request.getSession().getAttribute("user"));
        return CommonResult.success(orderService.getOrderInfo(map));
    }

}
