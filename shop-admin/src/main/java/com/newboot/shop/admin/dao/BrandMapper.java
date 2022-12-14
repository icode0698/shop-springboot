package com.newboot.shop.admin.dao;

import com.newboot.shop.admin.model.Brand;
import com.newboot.shop.admin.model.BrandExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer brandID);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer brandID);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    int getBrandNow();

    ArrayList<Brand> select(HashMap map);

    ArrayList<Brand> select();

    int update(HashMap map);

    int insert(HashMap map);
}