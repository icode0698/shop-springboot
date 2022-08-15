package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.GoodsMapper;
import com.newboot.shop.admin.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int getSpuNow() {
        return goodsMapper.getSpuNow();
    }

    @Override
    public int insert(HashMap map) {
        return 0;
    }

    @Override
    public ArrayList<JSONObject> select(HashMap map) {
        return goodsMapper.select(map);
    }

    @Override
    public int update(HashMap map) {
        return goodsMapper.update(map);
    }
}
