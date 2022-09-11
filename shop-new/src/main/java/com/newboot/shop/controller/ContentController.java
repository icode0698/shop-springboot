package com.newboot.shop.controller;

import com.newboot.shop.common.CommonResult;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.redis.RedisCache;
import com.newboot.shop.service.ContentService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    RedisCache redisCache;
    @Value("${redis.database}")
    String REDIS_DATABASE;
    @Value("${redis.key.product}")
    String REDIS_KEY_PRODUCT;
    @Value("${redis.expire.common}")
    long REDIS_EXPIRE_COMMON;

    @RequestMapping("/list")
    @ResponseBody
    public CommonResult list(@RequestParam HashMap map) {
        if (ObjectUtils.isNotEmpty(map.get("categoryName"))) {
            if (StringUtils.equals("手机", map.get("categoryName").toString())
                    && ObjectUtils.isNotEmpty(redisCache.get(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":phone"))) {
                return CommonResult.success(redisCache.get(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":phone"));
            }
            if (StringUtils.equals("电脑", map.get("categoryName").toString())
                    && ObjectUtils.isNotEmpty(redisCache.get(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":laptop"))) {
                return CommonResult.success(redisCache.get(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":laptop"));
            }
            if (StringUtils.equals("平板", map.get("categoryName").toString())
                    && ObjectUtils.isNotEmpty(redisCache.get(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":pad"))) {
                return CommonResult.success(redisCache.get(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":pad"));
            }
        } else {
            return CommonResult.failed(ResultMessage.PAGE_DATA_ERROR.getMessage());
        }
        return CommonResult.success(contentService.getList(map));
    }

    @RequestMapping("/details")
    @ResponseBody
    public CommonResult details(@RequestParam HashMap map) {
        return CommonResult.success(contentService.getDetails(Integer.parseInt(map.get("goodsID").toString())));
    }

    @RequestMapping("/price")
    @ResponseBody
    public CommonResult price(@RequestParam HashMap map) {
        return CommonResult.success(contentService.getPrice(map));
    }

    @RequestMapping("/showComment")
    @ResponseBody
    public CommonResult showComment(@RequestParam HashMap map) {
        return CommonResult.success(contentService.getComment(map));
    }

    @RequestMapping("/categoryAndBrand")
    @ResponseBody
    public CommonResult category(@RequestParam HashMap map) {
        return CommonResult.success(contentService.getCategoryAndBrand(map));
    }

    @RequestMapping("/search")
    @ResponseBody
    public CommonResult searchList(@RequestParam HashMap map) {
        return CommonResult.success(contentService.getSearchList(map));
    }
}
