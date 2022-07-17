package com.newboot.shop.dao;

import com.newboot.shop.model.Goodsvalue;
import com.newboot.shop.model.GoodsvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvalueMapper {
    long countByExample(GoodsvalueExample example);

    int deleteByExample(GoodsvalueExample example);

    int deleteByPrimaryKey(Integer spID);

    int insert(Goodsvalue record);

    int insertSelective(Goodsvalue record);

    List<Goodsvalue> selectByExample(GoodsvalueExample example);

    Goodsvalue selectByPrimaryKey(Integer spID);

    int updateByExampleSelective(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByExample(@Param("record") Goodsvalue record, @Param("example") GoodsvalueExample example);

    int updateByPrimaryKeySelective(Goodsvalue record);

    int updateByPrimaryKey(Goodsvalue record);
}