package com.newboot.shop.config;

import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目全局配置
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProjectConfig.class);

    /**
     * 项目名称
     */
    private static String name;
    /**
     * 用户头像上传文件路径
     */
    private static String userFileUploadPath;
    /**
     * 商品图片上传文件路径
     */
    private static String goodsFileUploadPath;
    /**
     * 订单超期未支付时间，单位秒
     */
    private static Integer orderUnpaidOverTime;
    /**
     * 服务端访问路径
     */
    private static String serverUrl;
    /**
     * xdb路径
     */
    private static String xdbPath;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getUserFileUploadPath() {
        return userFileUploadPath;
    }

    public void setUserFileUploadPath(String userFileUploadPath) {
        this.userFileUploadPath = userFileUploadPath;
    }

    public static String getGoodsFileUploadPath() {
        return goodsFileUploadPath;
    }

    public void setGoodsFileUploadPath(String goodsFileUploadPath) {
        this.goodsFileUploadPath = goodsFileUploadPath;
    }

    public static Integer getOrderUnpaidOverTime() {
        return orderUnpaidOverTime;
    }

    public void setOrderUnpaidOverTime(Integer orderUnpaidOverTime) {
        this.orderUnpaidOverTime = orderUnpaidOverTime;
    }

    public static String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public static String getXdbPath() {
        return xdbPath;
    }

    public void setXdbPath(String xdbPath) {
        this.xdbPath = xdbPath;
    }
}
