package com.newboot.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.dao.CategoryMapper;
import com.newboot.shop.dao.PriceMapper;
import com.newboot.shop.dao.ShopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.newboot.shop.service.OrderService;

import java.text.SimpleDateFormat;
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
            if(json.getIntValue("count")==0){
                map.put("id", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
                map.put("totalPrice", num*price);
                map.put("isPay", false);
                shopMapper.insertSelective(map);
            }
            else{
                map.put("num", addNum+num);
                map.put("totalPrice", (addNum+num)*price);
                shopMapper.updateJoin(map);
            }
        }catch (Exception e){
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
            map.put("unitPrice",json.getFloat("price"));
            map.put("categoryName", categoryMapper.getCategoryNameByGoodsID(Integer.parseInt(map.get("goodsID").toString())));
            if(shopMapper.reduceSkuStock(map)>0){
                map.put("id", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
                map.put("totalPrice", num*json.getFloat("price"));
                map.put("isPay", true);
                map.put("paymentTime", new Date());
                shopMapper.insertSelective(map);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
        return 1;
    }
}
