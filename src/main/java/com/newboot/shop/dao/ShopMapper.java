package com.newboot.shop.dao;

import com.newboot.shop.model.Shop;
import com.newboot.shop.model.ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(@Param("id") String id, @Param("user") String user);

    int insert(Shop row);

    int insertSelective(Shop row);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(@Param("id") String id, @Param("user") String user);

    int updateByExampleSelective(@Param("row") Shop row, @Param("example") ShopExample example);

    int updateByExample(@Param("row") Shop row, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop row);

    int updateByPrimaryKey(Shop row);
}