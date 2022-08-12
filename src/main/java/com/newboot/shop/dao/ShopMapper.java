package com.newboot.shop.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.model.Shop;
import com.newboot.shop.model.ShopExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(HashMap map);

    int insert(Shop record);

    int insertSelective(HashMap map);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(@Param("id") String id, @Param("user") String user);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    JSONObject getOrigin(HashMap map);

    int updateJoin(HashMap map);

    int reduceSkuStock(HashMap map);

    int reduceSkuStock(JSONObject json);

    ArrayList<Shop> getTrolleyList(HashMap map);

    ArrayList<Shop> getOrderList(HashMap map);

    int updatePayment(JSONObject json);

    int getOrderCount(HashMap map);

    JSONObject getOrderInfo(HashMap map);
}