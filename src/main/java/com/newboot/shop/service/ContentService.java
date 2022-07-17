package com.newboot.shop.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public interface ContentService {
    JSONObject getList(String categoryName);
}
