package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.ParameterMapper;
import com.newboot.shop.admin.dao.ParametervalueMapper;
import com.newboot.shop.admin.model.Parameter;
import com.newboot.shop.admin.service.ValueService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ValueServiceImpl implements ValueService {

    @Autowired
    ParameterMapper parameterMapper;
    @Autowired
    ParametervalueMapper parametervalueMapper;

    @Override
    public JSONObject getValueNow() {
        JSONObject json = new JSONObject();
        ArrayList<Parameter> parameterList =  parameterMapper.getParameter();
        HashMap map = new HashMap();
        map.put("parameterID", parameterList.get(0).getParameterID());
        json.put("storageNowID", parametervalueMapper.getValueNow(map));
        map.put("parameterID", parameterList.get(1).getParameterID());
        json.put("colorNowID", parametervalueMapper.getValueNow(map));
        map.put("parameterID", parameterList.get(2).getParameterID());
        json.put("screenNowID", parametervalueMapper.getValueNow(map));
        return json;
    }

    @Override
    public int insert(HashMap map) {
        if(StringUtils.equals("storage", map.get("message").toString())){
            map.put("parameterID", parameterMapper.getParameter().get(0).getParameterID());
        }
        if(StringUtils.equals("color", map.get("message").toString())){
            map.put("parameterID", parameterMapper.getParameter().get(1).getParameterID());
        }
        if(StringUtils.equals("screen", map.get("message").toString())){
            map.put("parameterID", parameterMapper.getParameter().get(2).getParameterID());
        }
        return parametervalueMapper.insert(map);
    }

    @Override
    public JSONObject select(HashMap map) {
        JSONObject json = new JSONObject();
        ArrayList<Parameter> parameterList = parameterMapper.getParameter();
        map.put("parameterID", parameterList.get(0).getParameterID());
        json.put("storageList", parametervalueMapper.getParameterValueByID(map));
        map.put("parameterID", parameterList.get(1).getParameterID());
        json.put("colorList", parametervalueMapper.getParameterValueByID(map));
        map.put("parameterID", parameterList.get(2).getParameterID());
        json.put("screenList", parametervalueMapper.getParameterValueByID(map));
        return json;
    }

    @Override
    public int update(HashMap map) {
        return parametervalueMapper.update(map);
    }
}
