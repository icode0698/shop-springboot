package com.newboot.shop.admin.common;

/**
 * 常用API返回对象接口
 */
public interface Result {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}

