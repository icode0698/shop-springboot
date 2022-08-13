package com.newboot.shop.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("headPic/**", "pic/**")
                .addResourceLocations("file:D:/Git/Gitee/shop-springboot/shop-admin/src/main/resources/static/headpic/")
                .addResourceLocations("file:D:/Git/Gitee/shop-springboot/shop-admin/src/main/resources/static/pic/");
    }
}
