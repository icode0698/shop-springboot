package com.newboot.shop.task;

import com.newboot.shop.redis.RedisCache;
import com.newboot.shop.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Slf4j
public class ProductCache implements ApplicationRunner {
    @Autowired
    ContentService contentService;
    @Autowired
    RedisCache redisCache;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Value("${redis.database}")
    String REDIS_DATABASE;
    @Value("${redis.key.product}")
    String REDIS_KEY_PRODUCT;
    @Value("${redis.expire.common}")
    long REDIS_EXPIRE_COMMON;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("System handle product cache begin");
        HashMap phone = new HashMap();
        phone.put("categoryName", "手机");
        threadPoolTaskExecutor.execute(() ->
                redisCache.set(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":phone", contentService.getList(phone)));
        HashMap laptop = new HashMap();
        laptop.put("categoryName", "电脑");
        threadPoolTaskExecutor.execute(() ->
                redisCache.set(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":laptop", contentService.getList(laptop)));
        HashMap pad = new HashMap();
        pad.put("categoryName", "平板");
        threadPoolTaskExecutor.execute(() ->
                redisCache.set(REDIS_DATABASE + REDIS_KEY_PRODUCT + ":pad", contentService.getList(pad)));
        log.info("System handle product cache complete");
    }
}
