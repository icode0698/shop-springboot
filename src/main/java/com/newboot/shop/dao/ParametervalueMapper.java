package com.newboot.shop.dao;

import com.newboot.shop.model.Parametervalue;
import com.newboot.shop.model.ParametervalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParametervalueMapper {
    long countByExample(ParametervalueExample example);

    int deleteByExample(ParametervalueExample example);

    int deleteByPrimaryKey(Integer valueid);

    int insert(Parametervalue row);

    int insertSelective(Parametervalue row);

    List<Parametervalue> selectByExample(ParametervalueExample example);

    Parametervalue selectByPrimaryKey(Integer valueid);

    int updateByExampleSelective(@Param("row") Parametervalue row, @Param("example") ParametervalueExample example);

    int updateByExample(@Param("row") Parametervalue row, @Param("example") ParametervalueExample example);

    int updateByPrimaryKeySelective(Parametervalue row);

    int updateByPrimaryKey(Parametervalue row);
}