package com.newboot.shop.config;

import com.newboot.shop.util.SpringContextUtil;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringConfig.class);

    @PostConstruct
    public void run() {
        LOGGER.info("Spring init method is RUNNING");
    }

    @PreDestroy
    public void destroy() {
        Searcher searcher = SpringContextUtil.getBean("getSearcher");
        try {
            // 关闭Searcher资源 -  searcher 对象可以安全用于并发，等整个服务关闭的时候再关闭 searcher
            searcher.close();
        } catch (Exception e) {
            LOGGER.error("Spring preDestroy method is ERROR , {}", e.toString());
        }
    }
}
