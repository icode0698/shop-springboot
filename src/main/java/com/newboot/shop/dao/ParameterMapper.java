package com.newboot.shop.dao;

import com.newboot.shop.model.Parameter;
import com.newboot.shop.model.ParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParameterMapper {
    long countByExample(ParameterExample example);

    int deleteByExample(ParameterExample example);

    int deleteByPrimaryKey(Integer parameterid);

    int insert(Parameter row);

    int insertSelective(Parameter row);

    List<Parameter> selectByExample(ParameterExample example);

    Parameter selectByPrimaryKey(Integer parameterid);

    int updateByExampleSelective(@Param("row") Parameter row, @Param("example") ParameterExample example);

    int updateByExample(@Param("row") Parameter row, @Param("example") ParameterExample example);

    int updateByPrimaryKeySelective(Parameter row);

    int updateByPrimaryKey(Parameter row);
}