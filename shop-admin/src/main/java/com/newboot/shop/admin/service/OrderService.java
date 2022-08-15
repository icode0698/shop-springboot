package com.newboot.shop.admin.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderService{
    ArrayList<JSONObject> select(HashMap map);
}
