package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.AdminMapper;
import com.newboot.shop.admin.dao.AdmininfoMapper;
import com.newboot.shop.admin.dao.MessageMapper;
import com.newboot.shop.admin.dao.UserMapper;
import com.newboot.shop.admin.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AdmininfoMapper admininfoMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public int login(HashMap map) {
        if(StringUtils.equals(map.get("password").toString(), adminMapper.getPassword(map))){
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public ArrayList<JSONObject> getBoInfo() {
        return admininfoMapper.getInfo();
    }

    @Override
    public ArrayList<JSONObject> getControl(HashMap map) {
        String type = map.get("type").toString();
        if(StringUtils.equals("user", type)){
            return userMapper.getList(map);
        }
        else{
            return messageMapper.getList(map);
        }
    }

    @Override
    public int offline(HashMap map) {
        return userMapper.offline(map);
    }
}
