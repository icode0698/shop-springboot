package com.newboot.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.common.CommonResult;

import java.util.HashMap;

public interface UserService {
    String login(JSONObject json);

    int logout(JSONObject json);

    JSONObject getInfo(String user);

    String register(JSONObject json);

    int comment(HashMap map);

    int message(HashMap map);

    int updateInfo(HashMap map);

    boolean userExist(JSONObject json);
}
