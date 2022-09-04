package com.newboot.shop.dao;

import com.newboot.shop.model.Goodspef;
import com.newboot.shop.model.GoodspefExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodspefMapper {
    long countByExample(GoodspefExample example);

    int deleteByExample(GoodspefExample example);

    int deleteByPrimaryKey(Integer spID);

    int insert(Goodspef record);

    int insertSelective(Goodspef record);

    List<Goodspef> selectByExample(GoodspefExample example);

    Goodspef selectByPrimaryKey(Integer spID);

    int updateByExampleSelective(@Param("record") Goodspef record, @Param("example") GoodspefExample example);

    int updateByExample(@Param("record") Goodspef record, @Param("example") GoodspefExample example);

    int updateByPrimaryKeySelective(Goodspef record);

    int updateByPrimaryKey(Goodspef record);

    String getSpValue(Integer spID);
}