package com.newboot.shop.admin.service;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public interface ValueService {
    JSONObject getValueNow();

    int insert(HashMap map);

    JSONObject select(HashMap map);

    int update(HashMap map);
}
