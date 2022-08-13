package com.newboot.shop.admin.common;

/**
 * 常用API返回对象
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(500),
    VALIDATE_FAILED(404),
    UNAUTHORIZED(401),
    FORBIDDEN(403);
    private long code;

    private ResultCode(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }

}
