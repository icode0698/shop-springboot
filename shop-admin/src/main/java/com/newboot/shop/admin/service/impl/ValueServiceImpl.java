package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.ParameterMapper;
import com.newboot.shop.admin.dao.ParametervalueMapper;
import com.newboot.shop.admin.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ValueServiceImpl implements ValueService {
    private static int storageID = 31000000;
    private static int colorID = 32000000;
    private static int screenID = 33000000;

    @Autowired
    ParameterMapper parameterMapper;
    @Autowired
    ParametervalueMapper parametervalueMapper;

    @Override
    public JSONObject getValueNow() {
        JSONObject json = new JSONObject();
        json.put("storageNowID", parametervalueMapper.getValueNow(storageID));
        json.put("colorNowID", parametervalueMapper.getValueNow(colorID));
        json.put("screenNowID", parametervalueMapper.getValueNow(screenID));
        return json;
    }

    @Override
    public int insert(HashMap map) {
        return 0;
    }

    @Override
    public JSONObject select(HashMap map) {
        JSONObject json = new JSONObject();
        json.put("storageList", parametervalueMapper.getParameterValueByID(storageID));
        json.put("colorList", parametervalueMapper.getParameterValueByID(colorID));
        json.put("screenList", parametervalueMapper.getParameterValueByID(screenID));
        return json;
    }

    @Override
    public int update(HashMap map) {
        return parametervalueMapper.update(map);
    }
}
