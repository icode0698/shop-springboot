package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.dao.CommentMapper;
import com.newboot.shop.dao.MessageMapper;
import com.newboot.shop.dao.UserMapper;
import com.newboot.shop.model.User;
import com.newboot.shop.service.UserService;
import com.newboot.shop.util.HttpUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    MessageMapper messageMapper;

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
            if (StringUtils.equals(json.getString("password"), user.getPassword())) {
                JSONObject ipJson = HttpUtil.getIpInfo(json.getString("ipAddress"));
                ipJson.put("ipAddress", json.getString("ipAddress"));
                ipJson.put("user", user.getUser());
                ipJson.put("online", (byte)1);
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
        json.put("ipRegion", HttpUtil.getIpPossession(json.getString("ipRegion")));
        return json;
    }

    @Override
    public String register(JSONObject json) {
        User user = userMapper.selectByPrimaryKey(json.getString("user"));
        if (ObjectUtils.isEmpty(user)) {
            user = JSONObject.toJavaObject(json, User.class);
            if (userMapper.insertSelective(user) > 0) {
                return ResultMessage.REGISTER_SUCCESS.getMessage();
            } else {
                return ResultMessage.SERVER_ERROR.getMessage();
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
        if (StringUtils.equals(map.get("originPass").toString(), userMapper.getPass(map.get("user").toString()))) {
            map.put("password", map.get("newPass"));
            return userMapper.updateByPrimaryKey(map);
        }
        return -1;
    }
}
