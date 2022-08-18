package com.newboot.shop.admin.dao;

import com.newboot.shop.admin.model.Goodsvalue;
import com.newboot.shop.admin.model.GoodsvalueExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvalueMapper {
    long countByExample(GoodsvalueExample example);

    int deleteByExample(GoodsvalueExample example);

    int deleteByPrimaryKey(Integer spID);

    int insertSelective(Goodsvalue record);

    List<Goodsvalue> selectByExample(GoodsvalueExample example);

    Goodsvalue selectByPrimaryKey(Integer spID);

    int updateByExampleSelective(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByExample(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByPrimaryKeySelective(Goodsvalue record);

    int updateByPrimaryKey(Goodsvalue record);

    String getSpValue(int spID);

    int getSpIDNow();

    int insert(HashMap map);

    int delete(HashMap map);
}