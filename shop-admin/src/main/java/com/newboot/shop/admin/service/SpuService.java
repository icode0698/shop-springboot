package com.newboot.shop.admin.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Future;

public interface SpuService {
    JSONObject getSpuNow();

    int getSpuImgNow();

    int insert(HashMap map);

    ArrayList<JSONObject> select(HashMap map);

    int update(HashMap map);

    int delete(HashMap map);
}
