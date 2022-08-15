package com.newboot.shop.admin.controller;

import com.newboot.shop.admin.common.CommonResult;
import com.newboot.shop.admin.common.ResultMessage;
import com.newboot.shop.admin.service.SpuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/spu")
public class SpuController {
    public final static Logger LOGGER = LoggerFactory.getLogger(SpuController.class);

    @Autowired
    SpuService spuService;

    @RequestMapping("/now")
    @ResponseBody
    public CommonResult now(){
        return CommonResult.success(spuService.getSpuNow());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public CommonResult insert(@RequestParam HashMap map){
        if(spuService.insert(map)<1){
            return CommonResult.failed();
        }
        return CommonResult.success();
    }

    @RequestMapping("/select")
    @ResponseBody
    public CommonResult select(@RequestParam HashMap map){
        return CommonResult.success(spuService.select(map));
    }

    @RequestMapping("/update")
    @ResponseBody
    public CommonResult update(@RequestParam HashMap map){
        try {
            if(spuService.update(map)<1){
                return CommonResult.failed();
            }
        }catch (Exception e){
            LOGGER.error(e.toString());
            return CommonResult.failed(ResultMessage.ADMIN_SPU_DATA_ERROR.getMessage());
        }
        return CommonResult.success();
    }
}