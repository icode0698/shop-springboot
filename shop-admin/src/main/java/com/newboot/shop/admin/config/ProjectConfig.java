package com.newboot.shop.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目全局配置
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

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
     * 密钥
     */
    private static String secretKey;

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
        ProjectConfig.serverUrl = serverUrl;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
