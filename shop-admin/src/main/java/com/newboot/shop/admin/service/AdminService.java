package com.newboot.shop.admin.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdminService {

    int login(HashMap map);

    ArrayList<JSONObject> getBoInfo();

    ArrayList<JSONObject> getControl(HashMap map);

    int offline(HashMap map);
}
