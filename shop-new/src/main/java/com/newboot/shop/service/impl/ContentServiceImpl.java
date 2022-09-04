package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.dao.*;
import com.newboot.shop.model.Comment;
import com.newboot.shop.model.Details;
import com.newboot.shop.model.Goods;
import com.newboot.shop.model.User;
import com.newboot.shop.service.ContentService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ImgMapper imgMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    ParameterMapper parameterMapper;
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodspefMapper goodspefMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public JSONObject getList(HashMap map) {
        ArrayList<JSONObject> goodsList = goodsMapper.getList(map);
        JSONObject json;
        for (int i = 0; i < goodsList.size(); i++) {
            json = goodsList.get(i);
            json.put("imgList", imgMapper.getImgList(Integer.parseInt(json.getString("goodsID"))));
        }
        json = new JSONObject();
        json.put("goodsList", goodsList);
        return json;
    }

    @Override
    public ArrayList<Details> getDetails(int goodsID) {
        Details details = new Details();
        ArrayList<Details> itemList = new ArrayList<Details>();
        JSONObject json = new JSONObject();
        ArrayList<String> imgList = new ArrayList<String>();
        ArrayList<String> storageList = new ArrayList<String>();
        ArrayList<String> colorList = new ArrayList<String>();
        ArrayList<String> screenList = new ArrayList<String>();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsID);
        imgList = imgMapper.getImgList(goodsID);
        details.setBrandName(brandMapper.getBrandNameFromGoods(goodsID));
        details.setGoodsName(goods.getGoodsName());
        details.setImgList(imgList);
        /*
         * 获取选中类别中产品的各项规格参数
         */
        storageList = parameterMapper.getValueFromName("存储", goodsID);
        colorList = parameterMapper.getValueFromName("颜色", goodsID);
        screenList = parameterMapper.getValueFromName("尺寸", goodsID);
        details.setStorageList(storageList);
        details.setColorList(colorList);
        details.setScreenList(screenList);
        itemList.add(details);
        return itemList;
    }

    @Override
    public JSONObject getPrice(HashMap map) {
        JSONObject json = priceMapper.getGoodsInfo(map);
        if (json.getIntValue("price") != 0) {
            json.put("price", new DecimalFormat("0.00").format(json.getFloat("price")));
        }
        return json;
    }

    @Override
    public ArrayList<Comment> getComment(HashMap map) {
        ArrayList<Comment> commentList = commentMapper.getComment(map);
        for (Comment comment : commentList) {
            User user = userMapper.selectByPrimaryKey(comment.getUser());
            comment.setHeadPic(user.getHeadPic());
            JSONObject json = priceMapper.getSkuInfo(comment.getSku());
            comment.setStorage(goodspefMapper.getSpValue(json.getInteger("spID1")));
            comment.setColor(goodspefMapper.getSpValue(json.getInteger("spID2")));
            comment.setScreen(goodspefMapper.getSpValue(json.getInteger("spID3")));
        }
        return commentList;
    }

    @Override
    public JSONObject getCategoryAndBrand(HashMap map) {
        JSONObject json = new JSONObject();
        json.put("categoryList", categoryMapper.getCategory());
        json.put("brandList", brandMapper.getBrand());
        return json;
    }

    @Override
    public JSONObject getSearchList(HashMap map) {
        if (ObjectUtils.isNotEmpty(map) && ObjectUtils.isNotEmpty(map.get("id"))) {
            if (StringUtils.isNotEmpty(map.get("id").toString())) {
                JSONObject goods = priceMapper.getSkuInfo(Integer.parseInt(map.get("id").toString()));
                if (ObjectUtils.isNotEmpty(goods)) {
                    map.put("spu", goods.getString("goodsID"));
                } else {
                    map.put("spu", map.get("id"));
                }
            }
        } else if (ObjectUtils.isNotEmpty(map.get("value"))) {
            String value = map.get("value").toString();
            if (StringUtils.isNotEmpty(value)) {
                JSONObject categoryID = categoryMapper.getCategoryID(value);
                JSONObject brandID = brandMapper.getBrandID(value);
                if (categoryID.getIntValue("count") > 0) {
                    map.put("categoryID", categoryID.getIntValue("categoryID"));
                } else if (brandID.getIntValue("count") > 0) {
                    map.put("brandID", brandID.getIntValue("brandID"));
                } else {
                    map.put("goodsName", value);
                }
            }
        }
        ArrayList<JSONObject> goodsList = goodsMapper.getList(map);
        JSONObject json;
        for (int i = 0; i < goodsList.size(); i++) {
            json = goodsList.get(i);
            json.put("imgList", imgMapper.getImgList(Integer.parseInt(json.getString("goodsID"))));
        }
        json = new JSONObject();
        json.put("goodsList", goodsList);
        return json;
    }
}
