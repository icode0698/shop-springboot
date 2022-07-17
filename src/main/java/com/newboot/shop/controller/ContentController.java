package com.newboot.shop.controller;

import com.newboot.shop.common.CommonResult;
import com.newboot.shop.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @RequestMapping("/list")
    @ResponseBody
    public CommonResult list(@RequestParam HashMap map){
        return CommonResult.success(contentService.getList(map.get("category").toString()));
    }
}
