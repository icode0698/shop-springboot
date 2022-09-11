package com.newboot.shop.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    public static boolean sendEmailNormal(String user, String type, String code, String fromEmail, String toEmail) {
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(toEmail)) {
            return false;
        }
        JavaMailSender javaMailSender = SpringContextUtil.getBean(JavaMailSenderImpl.class);
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject(type);
            simpleMailMessage.setText("尊敬的用户 " + user + " 你好，您收到的验证码是：" + code);
            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setTo(toEmail);
            javaMailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e) {
            LOGGER.error("{} send Email from {} to {}, Exception is {}", type, fromEmail, toEmail, e.toString());
        }
        return false;
    }
}
