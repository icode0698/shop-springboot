package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.ShopMapper;
import com.newboot.shop.admin.service.OrderService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ShopMapper shopMapper;

    @Override
    public JSONObject select(HashMap map) {
        JSONObject json = new JSONObject();
        if (ObjectUtils.isNotEmpty(map.get("page")) && ObjectUtils.isNotEmpty(map.get("limit"))) {
            map.put("offset", (Integer.parseInt(map.get("page").toString()) - 1) * Integer.parseInt(map.get("limit").toString()));
        }
        json.put("count", shopMapper.selectCount(map));
        json.put("list", shopMapper.select(map));
        return json;
    }
}
