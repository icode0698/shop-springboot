package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.AdminMapper;
import com.newboot.shop.admin.dao.AdmininfoMapper;
import com.newboot.shop.admin.dao.MessageMapper;
import com.newboot.shop.admin.dao.UserMapper;
import com.newboot.shop.admin.model.AdminUserDetails;
import com.newboot.shop.admin.service.AdminService;
import com.newboot.shop.admin.util.BCryptUtil;
import com.newboot.shop.security.util.JwtTokenUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(HashMap map) {
        String token = "";
        UserDetails userDetails = loadUserByUsername(map.get("admin").toString());
        if (ObjectUtils.isNotEmpty(map.get("password")) && ObjectUtils.isNotEmpty(adminMapper.getPassword(map)) &&
                BCryptUtil.checkpw(map.get("password").toString(), adminMapper.getPassword(map))) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        }
        return token;
    }

    @Override
    public ArrayList<JSONObject> getBoInfo() {
        return admininfoMapper.getInfo();
    }

    @Override
    public ArrayList<JSONObject> getControl(HashMap map) {
        String type = map.get("type").toString();
        if (StringUtils.equals("user", type)) {
            return userMapper.getList(map);
        } else {
            return messageMapper.getList(map);
        }
    }

    @Override
    public int offline(HashMap map) {
        return userMapper.offline(map);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new AdminUserDetails(adminMapper.selectByPrimaryKey(username));
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }
}
