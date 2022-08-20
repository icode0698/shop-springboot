package com.newboot.shop.config;

import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XdbConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(XdbConfig.class);

    @Bean
    public Searcher getSearcher(@Value("${project.xdbPath}") String xdbPath){
        LOGGER.info("{} is getting xdb Searcher", XdbConfig.class.toString());
        Searcher searcher;
        byte[] cBuff;
        try {
            cBuff = Searcher.loadContentFromFile(xdbPath);
        } catch (Exception e) {
            LOGGER.error("failed to load content from {}: {}", xdbPath, e);
            return null;
        }
        // 使用 cBuff 创建一个完全基于内存的查询对象
        try {
            searcher = Searcher.newWithBuffer(cBuff);
        } catch (Exception e) {
            LOGGER.error("failed to create content cached searcher: {}", e.toString());
            return null;
        }
        return searcher;
    }
}
