package com.newboot.shop.admin.controller;

import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("/now")
    @ResponseBody
    public CommonResult now(){
        return CommonResult.success(brandService.getBrandNow());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public CommonResult insert(@RequestParam HashMap map){
        if(brandService.insert(map)<1){
            return CommonResult.failed();
        }
        return CommonResult.success();
    }

    @RequestMapping("/select")
    @ResponseBody
    public CommonResult select(@RequestParam HashMap map){
        return CommonResult.success(brandService.select(map));
    }

    @RequestMapping("/update")
    @ResponseBody
    public CommonResult update(@RequestParam HashMap map){
        if(brandService.update(map)<1){
            CommonResult.failed();
        }
        return CommonResult.success();
    }
}
