package com.newboot.shop.dao;

import com.newboot.shop.model.Goods;
import com.newboot.shop.model.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsid);

    int insert(Goods row);

    int insertSelective(Goods row);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsid);

    int updateByExampleSelective(@Param("row") Goods row, @Param("example") GoodsExample example);

    int updateByExample(@Param("row") Goods row, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods row);

    int updateByPrimaryKey(Goods row);
}