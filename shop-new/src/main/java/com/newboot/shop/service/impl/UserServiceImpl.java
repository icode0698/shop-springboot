package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.dao.CommentMapper;
import com.newboot.shop.dao.MessageMapper;
import com.newboot.shop.dao.UserMapper;
import com.newboot.shop.model.User;
import com.newboot.shop.redis.RedisCache;
import com.newboot.shop.service.UserService;
import com.newboot.shop.util.BCryptUtil;
import com.newboot.shop.util.EmailUtil;
import com.newboot.shop.util.HttpUtil;
import com.newboot.shop.util.SystemUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.expire.authCode}")
    private Long REDIS_EXPIRE_AUTH_CODE;
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE;
    @Value("${spring.mail.username}")
    String fromEmail;

    @Override
    public String login(JSONObject json) {
        User user = new User();
        try {
            if (StringUtils.isEmpty(json.getString("user"))) {
                return ResultMessage.LOGIN_NAME_NULL.getMessage();
            }
            if (StringUtils.isEmpty(json.getString("password"))) {
                return ResultMessage.LOGIN_PASSWORD_NULL.getMessage();
            }
            user = userMapper.selectByPrimaryKey(json.getString("user"));
            if (user == null) {
                return ResultMessage.LOGIN_ERROR_PASSWORD.getMessage();
            }
            if (user.getOnline() == 1) {
                return ResultMessage.LOGIN_USER_ONLINE.getMessage();
            }
            if (BCryptUtil.checkpw(json.getString("password"), user.getPassword())) {
                JSONObject ipJson = HttpUtil.getIpInfo(json.getString("ipAddress"));
                ipJson.put("ipAddress", json.getString("ipAddress"));
                ipJson.put("user", user.getUser());
                ipJson.put("online", (byte) 1);
                ipJson.put("viewCount", user.getViewCount().intValue() + 1);
                ipJson.put("currentTime", new Date());
                userMapper.updateByPrimaryKeySelective(ipJson);
                return ResultMessage.LOGIN_SUCCESS.getMessage();
            } else {
                return ResultMessage.LOGIN_ERROR_PASSWORD.getMessage();
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ResultMessage.SERVER_ERROR.getMessage();
        }
    }

    @Override
    public int logout(JSONObject json) {
        User user = new User();
        user.setUser(json.getString("user"));
        user.setOnline((byte) 0);
        return userMapper.updateOnlineAndLastTime(user);
    }

    @Override
    public JSONObject getInfo(String user) {
        JSONObject json = userMapper.getInfo(user);
        if (StringUtils.isNotEmpty(json.getString("ipRegion"))) {
            json.put("ipRegion", HttpUtil.getIpPossession(json.getString("ipRegion")));
        }
        return json;
    }

    @Override
    public String register(JSONObject json) {
        if (ObjectUtils.isEmpty(redisCache.get(REDIS_DATABASE + REDIS_KEY_AUTH_CODE + ":" + json.getString("user")))) {
            return ResultMessage.VERIFY_CODE_INVALID.getMessage();
        }
        User user = userMapper.selectByPrimaryKey(json.getString("user"));
        if (ObjectUtils.isEmpty(user)) {
            user = JSONObject.toJavaObject(json, User.class);
            if (StringUtils.equals(json.getString("emailCode"), (String) redisCache.get(REDIS_DATABASE + REDIS_KEY_AUTH_CODE + ":" + json.getString("user")))) {
                user.setPassword(BCryptUtil.hashpw(user.getPassword()));
                if (userMapper.insertSelective(user) > 0) {
                    return ResultMessage.REGISTER_SUCCESS.getMessage();
                } else {
                    return ResultMessage.SERVER_ERROR.getMessage();
                }
            } else {
                return ResultMessage.LOGIN_VERIFY_CODE_ERROR.getMessage();
            }
        } else {
            return ResultMessage.SAME_LOGIN_NAME_EXIST.getMessage();
        }
    }

    @Override
    public int comment(HashMap map) {
        return commentMapper.insertSelective(map);
    }

    @Override
    public int message(HashMap map) {
        return messageMapper.insertSelective(map);
    }

    @Override
    public int updateInfo(HashMap map) {
        if (ObjectUtils.isEmpty(map.get("originPass"))) {
            return userMapper.updateByPrimaryKey(map);
        }
        if (BCryptUtil.checkpw(map.get("originPass").toString(), userMapper.getPass(map.get("user").toString()))) {
            map.put("password", BCryptUtil.hashpw(map.get("newPass").toString()));
            return userMapper.updateByPrimaryKey(map);
        }
        return -1;
    }

    @Override
    public boolean userExist(JSONObject json) {
        if (ObjectUtils.isNotEmpty(userMapper.selectByPrimaryKey(json.getString("user")))) {
            return true;
        }
        return false;
    }

    @KafkaListener(topics = {"emailCode"})
    public void codeEmail(ConsumerRecord record) {
        logger.info("record info: {}", record);
        logger.info("record value info: {}", record.value());
        JSONObject json = JSONObject.parseObject(record.value().toString());
        logger.info("json info: {}", json);
        String code = RandomStringUtils.randomNumeric(6);
        redisCache.set(REDIS_DATABASE + REDIS_KEY_AUTH_CODE + ":" + json.getString("user"), code, REDIS_EXPIRE_AUTH_CODE);
        EmailUtil.sendEmailNormal(json.getString("user"), "注册验证码", code, fromEmail, json.getString("email"));
    }

    @KafkaListener(topics = {"testtopic"})
    public void test(ConsumerRecord<?, ?> record) {
        logger.info("{} {} kafkaListener test ok", UserServiceImpl.class.toString(), new Date().getTime());
        logger.info("简单消费consumer ok：{} - {} - {}", record.topic(), record.partition(), record.value());
    }
}
