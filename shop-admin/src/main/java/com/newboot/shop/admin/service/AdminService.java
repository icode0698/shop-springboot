package com.newboot.shop.admin.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdminService {

    String login(HashMap map);

    ArrayList<JSONObject> getBoInfo();

    ArrayList<JSONObject> getControl(HashMap map);

    int offline(HashMap map);

    UserDetails loadUserByUsername(String username);

    String refreshToken(String token);
}
