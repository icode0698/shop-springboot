package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.dao.UserMapper;
import com.newboot.shop.model.User;
import com.newboot.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String login(JSONObject json) {
            User user = new User();
        try {
            if(StringUtils.isEmpty(json.getString("user"))){
                return ResultMessage.LOGIN_NAME_NULL.getMessage();
            }
            if(StringUtils.isEmpty(json.getString("password"))){
                return ResultMessage.LOGIN_PASSWORD_NULL.getMessage();
            }
            logger.debug(json.getString("user"));
            user = userMapper.selectByPrimaryKey(json.getString("user"));
            if(user==null){
                return ResultMessage.LOGIN_ERROR_PASSWORD.getMessage();
            }
            if(user.getOnline()==1){
                return ResultMessage.LOGIN_USER_ONLINE.getMessage();
            }
            if(StringUtils.equals(json.getString("password"),user.getPassword())){
                User after = new User();
                after.setUser(user.getUser());
                after.setOnline((byte) 1);
                after.setViewCount(user.getViewCount().intValue()+1);
                after.setCurrentTime(new Date());
                userMapper.updateByPrimaryKeySelective(after);
                return ResultMessage.LOGIN_SUCCESS.getMessage();
            }
            else{
                return ResultMessage.LOGIN_ERROR_PASSWORD.getMessage();
            }
        }catch (Exception e){
            logger.debug(e.getMessage());
            return ResultMessage.SERVER_ERROR.getMessage();
        }
    }

    @Override
    public int logout(JSONObject json) {
        User user = new User();
        user.setUser(json.getString("user"));
        user.setOnline((byte)0);
        return userMapper.updateOnlineAndLastTime(user);
    }

    @Override
    public JSONObject getInfo(String user) {
        User info = userMapper.selectByPrimaryKey(user);
        info.setPassword("password");
        return (JSONObject)JSONObject.toJSON(info);
    }

}
