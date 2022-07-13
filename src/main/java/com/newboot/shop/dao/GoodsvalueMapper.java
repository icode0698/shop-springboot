package com.newboot.shop.dao;

import com.newboot.shop.model.Goodsvalue;
import com.newboot.shop.model.GoodsvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvalueMapper {
    long countByExample(GoodsvalueExample example);

    int deleteByExample(GoodsvalueExample example);

    int deleteByPrimaryKey(Integer spid);

    int insert(Goodsvalue row);

    int insertSelective(Goodsvalue row);

    List<Goodsvalue> selectByExample(GoodsvalueExample example);

    Goodsvalue selectByPrimaryKey(Integer spid);

    int updateByExampleSelective(@Param("row") Goodsvalue row, @Param("example") GoodsvalueExample example);

    int updateByExample(@Param("row") Goodsvalue row, @Param("example") GoodsvalueExample example);

    int updateByPrimaryKeySelective(Goodsvalue row);

    int updateByPrimaryKey(Goodsvalue row);
}