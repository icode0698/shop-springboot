package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.ShopMapper;
import com.newboot.shop.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    ShopMapper shopMapper;

    @Override
    public ArrayList<JSONObject> select(HashMap map) {
        return shopMapper.select(map);
    }
}
