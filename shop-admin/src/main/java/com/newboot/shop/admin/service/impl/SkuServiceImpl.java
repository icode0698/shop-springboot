package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.GoodspefMapper;
import com.newboot.shop.admin.dao.PriceMapper;
import com.newboot.shop.admin.service.SkuService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    GoodspefMapper goodspefMapper;

    @Override
    public JSONObject select(HashMap map) {
        JSONObject json = new JSONObject();
        json.put("count", priceMapper.getSkuListCount(map));
        if (ObjectUtils.isNotEmpty(map.get("page")) && ObjectUtils.isNotEmpty(map.get("limit"))) {
            map.put("offset", (Integer.parseInt(map.get("page").toString()) - 1) * Integer.parseInt(map.get("limit").toString()));
        }
        ArrayList<JSONObject> list = priceMapper.getSkuList(map);
        for (JSONObject jsonObject : list) {
            jsonObject.put("storage", goodspefMapper.getSpValue(jsonObject.getIntValue("spID1")));
            jsonObject.put("color", goodspefMapper.getSpValue(jsonObject.getIntValue("spID2")));
            jsonObject.put("screen", goodspefMapper.getSpValue(jsonObject.getIntValue("spID3")));
        }
        json.put("list", list);
        return json;
    }

    @Override
    public int update(HashMap map) {
        return priceMapper.update(map);
    }
}
