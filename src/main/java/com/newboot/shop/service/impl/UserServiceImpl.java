package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.ResultMessage;
import com.newboot.shop.dao.UserMapper;
import com.newboot.shop.model.User;
import com.newboot.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private User user;

    @Override
    public String login(JSONObject json) {
        if(StringUtils.isEmpty(json.getString("user"))){
            return ResultMessage.LOGIN_NAME_NULL.getMessage();
        }
        if(StringUtils.isEmpty(json.getString("password"))){
            return ResultMessage.LOGIN_PASSWORD_NULL.getMessage();
        }
        user = userMapper.selectByPrimaryKey(json.getString("user"));
        if(user==null){
            return ResultMessage.LOGIN_ERROR_PASSWORD.getMessage();
        }
        if(user.getOnline()==1){
            return ResultMessage.LOGIN_USER_ONLINE.getMessage();
        }
        if(StringUtils.equals(json.getString("password"),user.getPassword())){
            user.setViewcount(user.getViewcount().intValue()+1);
            userMapper.updateCurrentTimeByUser(user);
            return ResultMessage.LOGIN_SUCCESS.getMessage();
        }
        else{
            return ResultMessage.LOGIN_ERROR_PASSWORD.getMessage();
        }
    }

}
