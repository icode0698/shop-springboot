package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.GoodsvalueMapper;
import com.newboot.shop.admin.dao.PriceMapper;
import com.newboot.shop.admin.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    GoodsvalueMapper goodsvalueMapper;

    @Override
    public ArrayList<JSONObject> select(HashMap map) {
        ArrayList<JSONObject> list = priceMapper.getSkuList(map);
        for (JSONObject jsonObject : list) {
            jsonObject.put("storage",goodsvalueMapper.getSpValue(jsonObject.getIntValue("spID1")));
            jsonObject.put("color",goodsvalueMapper.getSpValue(jsonObject.getIntValue("spID2")));
            jsonObject.put("screen",goodsvalueMapper.getSpValue(jsonObject.getIntValue("spID3")));
        }
        return list;
    }

    @Override
    public int update(HashMap map) {
        return priceMapper.update(map);
    }
}
