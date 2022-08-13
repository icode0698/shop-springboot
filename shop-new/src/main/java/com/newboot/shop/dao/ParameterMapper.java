package com.newboot.shop.dao;

import com.newboot.shop.model.Parameter;
import com.newboot.shop.model.ParameterExample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ParameterMapper {
    long countByExample(ParameterExample example);

    int deleteByExample(ParameterExample example);

    int deleteByPrimaryKey(Integer parameterID);

    int insert(Parameter record);

    int insertSelective(Parameter record);

    List<Parameter> selectByExample(ParameterExample example);

    Parameter selectByPrimaryKey(Integer parameterID);

    int updateByExampleSelective(@Param("record") Parameter record, @Param("example") ParameterExample example);

    int updateByExample(@Param("record") Parameter record, @Param("example") ParameterExample example);

    int updateByPrimaryKeySelective(Parameter record);

    int updateByPrimaryKey(Parameter record);

    ArrayList<String> getValueFromName(@Param("parameterName") String parameterName, @Param("goodsID") int goodsID);
}