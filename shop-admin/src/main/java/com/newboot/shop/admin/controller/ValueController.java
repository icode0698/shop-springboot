package com.newboot.shop.admin.controller;

import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.service.BrandService;
import com.newboot.shop.admin.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/value")
public class ValueController {
    @Autowired
    ValueService valueService;

    @RequestMapping("/now")
    @ResponseBody
    public CommonResult now(){
        return CommonResult.success(valueService.getValueNow());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public CommonResult insert(@RequestParam HashMap map){
        if(valueService.insert(map)<1){
            return CommonResult.failed();
        }
        return CommonResult.success();
    }

    @RequestMapping("/select")
    @ResponseBody
    public CommonResult select(@RequestParam HashMap map){
        return CommonResult.success(valueService.select(map));
    }

    @RequestMapping("/update")
    @ResponseBody
    public CommonResult update(@RequestParam HashMap map){
        if(valueService.update(map)<1){
            return CommonResult.failed();
        }
        return CommonResult.success();
    }

}
