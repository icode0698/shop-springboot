package com.newboot.shop.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.model.Brand;
import com.newboot.shop.model.BrandExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer brandID);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer brandID);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    String getBrandNameFromGoods(Integer goodsID);

    ArrayList<JSONObject> getBrand();

    JSONObject getBrandID(String brandName);
}