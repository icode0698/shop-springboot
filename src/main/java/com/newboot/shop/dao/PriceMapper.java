package com.newboot.shop.dao;

import com.newboot.shop.model.Price;
import com.newboot.shop.model.PriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceMapper {
    long countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(Integer sku);

    int insert(Price row);

    int insertSelective(Price row);

    List<Price> selectByExample(PriceExample example);

    Price selectByPrimaryKey(Integer sku);

    int updateByExampleSelective(@Param("row") Price row, @Param("example") PriceExample example);

    int updateByExample(@Param("row") Price row, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price row);

    int updateByPrimaryKey(Price row);
}