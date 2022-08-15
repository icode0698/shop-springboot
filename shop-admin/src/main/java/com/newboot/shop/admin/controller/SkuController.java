package com.newboot.shop.admin.controller;

import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/sku")
public class SkuController {
    @Autowired
    SkuService skuService;

    @RequestMapping("/select")
    @ResponseBody
    public CommonResult select(@RequestParam HashMap map){
        return CommonResult.success(skuService.select(map));
    }

    @RequestMapping("/update")
    @ResponseBody
    public CommonResult update(@RequestParam HashMap map){
        if(skuService.update(map)<1){
            return CommonResult.failed();
        }
        return CommonResult.success();
    }
}
