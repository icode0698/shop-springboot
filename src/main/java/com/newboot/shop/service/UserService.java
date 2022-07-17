package com.newboot.shop.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
    String login(JSONObject json);

    int logout(JSONObject json);

    JSONObject getInfo(String uesr);
}
