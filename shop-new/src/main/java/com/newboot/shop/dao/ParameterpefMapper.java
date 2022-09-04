package com.newboot.shop.dao;

import com.newboot.shop.model.Parameterpef;
import com.newboot.shop.model.ParameterpefExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ParameterpefMapper {
    long countByExample(ParameterpefExample example);

    int deleteByExample(ParameterpefExample example);

    int deleteByPrimaryKey(Integer valueID);

    int insert(Parameterpef record);

    int insertSelective(Parameterpef record);

    List<Parameterpef> selectByExample(ParameterpefExample example);

    Parameterpef selectByPrimaryKey(Integer valueID);

    int updateByExampleSelective(@Param("record") Parameterpef record, @Param("example") ParameterpefExample example);

    int updateByExample(@Param("record") Parameterpef record, @Param("example") ParameterpefExample example);

    int updateByPrimaryKeySelective(Parameterpef record);

    int updateByPrimaryKey(Parameterpef record);
}