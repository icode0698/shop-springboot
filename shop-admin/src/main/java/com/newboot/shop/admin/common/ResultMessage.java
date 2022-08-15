package com.newboot.shop.admin.common;

/**
 * @author liuwei
 */
public enum ResultMessage {
    FAIL("操作失败"),

    SUCCESS("操作成功"),

    UNAUTHORIZED("用户未登录"),

    FORBIDDEN("用户未授权"),

    LOGIN_USER_ONLINE("用户已在线"),

    LOGIN_SUCCESS("登录成功"),

    LOGIN_ERROR_PASSWORD("用户名密码错误"),

    LOGIN_USER_OFFLINE("用户下线成功"),

    SERVER_ERROR("服务器异常"),

    REGISTER_SUCCESS("注册成功"),

    UPLOAD_FILE_SUCCESS("文件上传成功"),

    UPLOAD_FILE_FAIL("文件上传失败"),

    DATA_NOT_EXIST("未查询到记录"),

    SAME_CATEGORY_EXIST("已存在同级同名的分类"),

    SAME_LOGIN_NAME_EXIST("用户名已存在"),

    LOGIN_NULL("请输入用户名密码"),

    LOGIN_NAME_NULL("请输入登录名"),

    LOGIN_PASSWORD_NULL("请输入密码"),

    COMMENT_SUCCESS("商品评价成功"),

    COMMENT_ERROR("商品评价出现错误"),

    MESSAGE_SUCCESS("留言成功"),

    MESSAGE_ERROR("留言出现错误"),

    TROLLEY_JOIN_SUCCESS("加入购物车成功"),

    TROLLEY_JOIN_ERROR("加入购物车出现错误"),

    PURCHASE_SUCCESS("商品购买成功，感谢您的支持"),

    PURCHASE_PAY_ERROR("支付异常，库存数量已回退"),

    PURCHASE_DB_ERROR("支付异常，数据库回退库存数量异常"),

    PAGE_DATA_ERROR("页面数据异常"),

    ORDER_TROLLEY_DELETE("已将商品移出购物车"),

    ORDER_DELETE("订单删除成功"),

    ORDER_DATA_ERROR("订单数据异常"),

    ADMIN_SPU_DATA_ERROR("请输入正确的分类和品牌"),

    LOGIN_VERIFY_CODE_NULL("请输入验证码"),

    LOGIN_VERIFY_CODE_ERROR("验证码错误"),

    SAME_INDEX_CONFIG_EXIST("已存在相同的首页配置项"),

    GOODS_CATEGORY_ERROR("分类数据异常"),

    SAME_GOODS_EXIST("已存在相同的商品信息"),

    GOODS_NOT_EXIST("商品不存在"),

    GOODS_PUT_DOWN("商品已下架"),

    SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR("超出单个商品的最大购买数量"),

    SHOPPING_CART_ITEM_TOTAL_NUMBER_ERROR("超出购物车最大容量"),

    LOGIN_ERROR("登录失败"),

    LOGIN_USER_LOCKED("用户已被禁止登录"),

    ORDER_NOT_EXIST_ERROR("订单不存在"),

    ORDER_ITEM_NOT_EXIST_ERROR("订单项不存在"),

    NULL_ADDRESS_ERROR("地址不能为空"),

    ORDER_PRICE_ERROR("订单价格异常"),

    ORDER_GENERATE_ERROR("生成订单异常"),

    SHOPPING_ITEM_ERROR("购物车数据异常"),

    SHOPPING_ITEM_COUNT_ERROR("库存不足"),

    ORDER_STATUS_ERROR("订单状态异常"),

    OPERATE_ERROR("操作失败"),

    NO_PERMISSION_ERROR("无权限"),

    DB_ERROR("数据库异常");

    private String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}