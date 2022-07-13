package com.newboot.shop.dao;

import com.newboot.shop.model.Category;
import com.newboot.shop.model.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer categoryid);

    int insert(Category row);

    int insertSelective(Category row);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer categoryid);

    int updateByExampleSelective(@Param("row") Category row, @Param("example") CategoryExample example);

    int updateByExample(@Param("row") Category row, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category row);

    int updateByPrimaryKey(Category row);
}