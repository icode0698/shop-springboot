package com.newboot.shop.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.model.Price;
import com.newboot.shop.admin.model.PriceExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceMapper {
    long countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(Integer sku);

    int insertSelective(Price record);

    List<Price> selectByExample(PriceExample example);

    Price selectByPrimaryKey(Integer sku);

    int updateByExampleSelective(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByExample(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);

    ArrayList<JSONObject> getSkuListByCategoryName(HashMap map);

    ArrayList<JSONObject> getSkuList(HashMap map);

    int update(HashMap map);

    int getSkuNow();

    int insert(HashMap map);

    int delete(HashMap map);
}