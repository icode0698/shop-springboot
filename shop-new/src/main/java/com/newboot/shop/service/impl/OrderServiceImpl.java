package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.dao.CategoryMapper;
import com.newboot.shop.dao.GoodsMapper;
import com.newboot.shop.dao.PriceMapper;
import com.newboot.shop.dao.ShopMapper;
import com.newboot.shop.model.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.newboot.shop.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int join(HashMap map) {
        JSONObject json = new JSONObject();
        int num = Integer.parseInt(map.get("num").toString());
        try {
            json = priceMapper.getGoodsInfo(map);
            float price = json.getFloat("price");
            map.put("sku", json.getString("sku"));
            map.put("unitPrice", price);
            map.put("categoryName", categoryMapper.getCategoryNameByGoodsID(Integer.parseInt(map.get("goodsID").toString())));
            json = shopMapper.getOrigin(map);
            int addNum = json.getIntValue("num");
            if (json.getIntValue("count") == 0) {
                map.put("id", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
                map.put("totalPrice", num * price);
                map.put("isPay", false);
                shopMapper.insertSelective(map);
            } else {
                map.put("num", addNum + num);
                map.put("totalPrice", (addNum + num) * price);
                shopMapper.updateJoin(map);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public int purchase(HashMap map) {
        JSONObject json = new JSONObject();
        int num = Integer.parseInt(map.get("num").toString());
        try {
            json = priceMapper.getGoodsInfo(map);
            map.put("sku", json.getInteger("sku"));
            map.put("unitPrice", json.getFloat("price"));
            map.put("categoryName", categoryMapper.getCategoryNameByGoodsID(Integer.parseInt(map.get("goodsID").toString())));
            if (shopMapper.reduceSkuStock(map) > 0) {
                map.put("id", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
                map.put("totalPrice", num * json.getFloat("price"));
                map.put("isPay", true);
                map.put("paymentTime", new Date());
                shopMapper.insertSelective(map);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public ArrayList<Shop> getTrolleyList(HashMap map) {
        ArrayList<Shop> shopList = shopMapper.getTrolleyList(map);
        for (Shop shop : shopList) {
            JSONObject json = priceMapper.getSkuInfo(shop.getSku());
            shop.setSpu(json.getIntValue("goodsID"));
            shop.setImgList(goodsMapper.getImgListBySpu(json.getIntValue("goodsID")));
            shop.setStock(json.getIntValue("stock"));
        }
        return shopList;
    }

    @Override
    public ArrayList<Shop> getOrderList(HashMap map) {
        ArrayList<Shop> shopList = shopMapper.getOrderList(map);
        for (Shop shop : shopList) {
            JSONObject json = priceMapper.getSkuInfo(shop.getSku());
            shop.setSpu(json.getIntValue("goodsID"));
            shop.setImgList(goodsMapper.getImgListBySpu(json.getIntValue("goodsID")));
            shop.setStock(json.getIntValue("stock"));
        }
        return shopList;
    }

    @Override
    public int trolleySettlement(JSONObject json) {
        JSONArray list = json.getJSONArray("idList");
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonIndex = list.getJSONObject(i);
            JSONObject jsonSku = priceMapper.getSkuInfo(jsonIndex.getIntValue("sku"));
            if (jsonSku.getIntValue("stock") == 0 || jsonIndex.getIntValue("num") > jsonSku.getIntValue("stock")) {
                return -1;
            }
            if (shopMapper.reduceSkuStock(jsonIndex) < 0) {
                return -1;
            }
            jsonIndex.put("isPay", true);
            jsonIndex.put("paymentTime", new Date());
            shopMapper.updatePayment(jsonIndex);
        }
        return 1;
    }

    @Override
    public int trolleyDelete(HashMap map) {
        return shopMapper.deleteByPrimaryKey(map);
    }

    @Override
    public int delete(HashMap map) {
        return shopMapper.deleteByPrimaryKey(map);
    }

    @Override
    public JSONObject getOrderInfo(HashMap map) {
        JSONObject json = new JSONObject();
        if (shopMapper.getOrderCount(map) < 1) {
            return json;
        }
        json = shopMapper.getOrderInfo(map);
        json.put("spu", priceMapper.getSkuInfo(json.getIntValue("sku")).getIntValue("goodsID"));
        return json;
    }
}
