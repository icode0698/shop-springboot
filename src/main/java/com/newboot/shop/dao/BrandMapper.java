package com.newboot.shop.dao;

import com.newboot.shop.model.Brand;
import com.newboot.shop.model.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer brandid);

    int insert(Brand row);

    int insertSelective(Brand row);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer brandid);

    int updateByExampleSelective(@Param("row") Brand row, @Param("example") BrandExample example);

    int updateByExample(@Param("row") Brand row, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand row);

    int updateByPrimaryKey(Brand row);
}