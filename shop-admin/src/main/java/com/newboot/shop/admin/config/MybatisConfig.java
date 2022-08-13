package com.newboot.shop.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.newboot.shop.dao.mapper")
public class MybatisConfig {

}
