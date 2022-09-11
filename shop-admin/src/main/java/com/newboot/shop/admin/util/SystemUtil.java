package com.newboot.shop.admin.util;

import com.newboot.shop.admin.config.ProjectConfig;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SystemUtil {

    private SystemUtil() {
    }

    /**
     * 登录或注册成功后,生成保持用户登录状态会话token值
     *
     * @param src:为用户最新一次登录时的now()+user.id+random(4)
     * @return
     */
    public static String genToken(String src) {
        if (null == src || "".equals(src)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);
            if (result.length() == 31) {
                result = result + "-";
            }
            System.out.println(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 加密
     *
     * @param pass
     * @return
     */
    public static String encrypt(String pass) {
        byte[] passArray = pass.getBytes(StandardCharsets.UTF_8);
        byte[] secretArray = "123456".getBytes(StandardCharsets.UTF_8);
        int p = passArray.length;
        int s = secretArray.length;
        for (int i = 0; i < p; i++) {
            passArray[i] = (byte) (passArray[i] + secretArray[i % s]);
        }
        return new String(passArray);
    }

    /**
     * 解密
     *
     * @param pass
     * @return
     */
    public static String decrypt(String pass) {
        byte[] passArray = pass.getBytes(StandardCharsets.UTF_8);
        byte[] secretArray = "123456".getBytes(StandardCharsets.UTF_8);
        int p = passArray.length;
        int s = secretArray.length;
        for (int i = 0; i < p; i++) {
            passArray[i] = (byte) (passArray[i] - secretArray[i % s]);
        }
        return new String(passArray);
    }
}
