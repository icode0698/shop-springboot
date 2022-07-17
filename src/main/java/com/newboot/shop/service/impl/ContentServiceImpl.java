package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.dao.GoodsMapper;
import com.newboot.shop.dao.ImgMapper;
import com.newboot.shop.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ImgMapper imgMapper;

    @Override
    public JSONObject getList(String categoryName) {
        ArrayList<JSONObject> goodsList = goodsMapper.getList(categoryName);
        JSONObject json = new JSONObject();
        for(int i = 0; i < goodsList.size(); i++){
            json = goodsList.get(i);
            json.put("imgList",imgMapper.getImgList(Integer.parseInt(json.getString("goodsID"))));
        }
        json.put("categoryName", categoryName);
        json.put("goodsList", goodsList);
        return json;
    }
}
