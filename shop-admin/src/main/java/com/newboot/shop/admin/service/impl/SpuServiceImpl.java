package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.*;
import com.newboot.shop.admin.model.Parameter;
import com.newboot.shop.admin.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ParametervalueMapper parametervalueMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    ParameterMapper parameterMapper;
    @Autowired
    ImgMapper imgMapper;
    @Autowired
    GoodsvalueMapper goodsvalueMapper;
    @Autowired
    PriceMapper priceMapper;

    @Override
    public JSONObject getSpuNow() {
        JSONObject json = new JSONObject();
        json.put("spuNow", goodsMapper.getSpuNow());
        json.put("categoryList", categoryMapper.select());
        json.put("brandList", brandMapper.select());
        ArrayList<Parameter> parameterList = parameterMapper.getParameter();
        HashMap map = new HashMap();
        map.put("parameterID", parameterList.get(0).getParameterID());
        json.put("storageList", parametervalueMapper.getParameterValueByID(map));
        map.put("parameterID", parameterList.get(1).getParameterID());
        json.put("colorList", parametervalueMapper.getParameterValueByID(map));
        map.put("parameterID", parameterList.get(2).getParameterID());
        json.put("screenList", parametervalueMapper.getParameterValueByID(map));
        return json;
    }

    @Override
    public int getSpuImgNow() {
        return imgMapper.getSpuImgNow();
    }

    @Override
    public int insert(HashMap map) {
        if(goodsMapper.insert(map)>0){
            imgMapper.insert(map);
            JSONObject json = new JSONObject(map);
            int spIDNow = goodsvalueMapper.getSpIDNow();
            int skuNow = priceMapper.getSkuNow();
            JSONArray storageArray = json.getJSONArray("storageList");
            JSONArray colorArray = json.getJSONArray("colorList");
            JSONArray screenArray = json.getJSONArray("screenList");
            ArrayList<Parameter> parameterList = parameterMapper.getParameter();
            int storageID = parameterList.get(0).getParameterID();
            int colorID = parameterList.get(1).getParameterID();
            int screenID = parameterList.get(2).getParameterID();
            ArrayList<Integer> storageIDList = new ArrayList<>();
            ArrayList<Integer> colorIDList = new ArrayList<>();
            ArrayList<Integer> screenIDList = new ArrayList<>();
            for (int i = 0; i < storageArray.size(); i++) {
                map.put("spID", ++spIDNow);
                map.put("goodsID", json.getIntValue("goodsID"));
                map.put("valueID", storageArray.getIntValue(i));
                map.put("parameterID", storageID);
                goodsvalueMapper.insert(map);
                storageIDList.add(spIDNow);
            }
            for (int i = 0; i < colorArray.size(); i++) {
                map.put("spID", ++spIDNow);
                map.put("goodsID", json.getIntValue("goodsID"));
                map.put("valueID", colorArray.getIntValue(i));
                map.put("parameterID", colorID);
                goodsvalueMapper.insert(map);
                colorIDList.add(spIDNow);
            }
            for (int i = 0; i < screenArray.size(); i++) {
                map.put("spID", ++spIDNow);
                map.put("goodsID", json.getIntValue("goodsID"));
                map.put("valueID", screenArray.getIntValue(i));
                map.put("parameterID", screenID);
                goodsvalueMapper.insert(map);
                screenIDList.add(spIDNow);
            }
            for (int i = 0; i < storageIDList.size(); i++) {
                for (int j = 0; j < colorIDList.size(); j++) {
                    for (int k = 0; k < screenIDList.size(); k++) {
                        map.put("sku", ++skuNow);
                        map.put("goodsID", json.getIntValue("goodsID"));
                        map.put("spID1", storageIDList.get(i));
                        map.put("spID2", colorIDList.get(j));
                        map.put("spID3", screenIDList.get(k));
                        priceMapper.insert(map);
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    @Override
    public ArrayList<JSONObject> select(HashMap map) {
        return goodsMapper.select(map);
    }

    @Override
    public int update(HashMap map) {
        return goodsMapper.update(map);
    }

    @Override
    public int delete(HashMap map) {
        priceMapper.delete(map);
        goodsvalueMapper.delete(map);
        imgMapper.delete(map);
        return goodsMapper.delete(map);
    }
}
