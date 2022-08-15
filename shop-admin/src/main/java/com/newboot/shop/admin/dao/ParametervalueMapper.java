package com.newboot.shop.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.model.Parametervalue;
import com.newboot.shop.admin.model.ParametervalueExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParametervalueMapper {
    long countByExample(ParametervalueExample example);

    int deleteByExample(ParametervalueExample example);

    int deleteByPrimaryKey(Integer valueID);

    int insert(Parametervalue record);

    int insertSelective(Parametervalue record);

    List<Parametervalue> selectByExample(ParametervalueExample example);

    Parametervalue selectByPrimaryKey(Integer valueID);

    int updateByExampleSelective(@Param("record") Parametervalue record, @Param("example") ParametervalueExample example);

    int updateByExample(@Param("record") Parametervalue record, @Param("example") ParametervalueExample example);

    int updateByPrimaryKeySelective(Parametervalue record);

    int updateByPrimaryKey(Parametervalue record);

    ArrayList<JSONObject> getParameterValueByID(int parameterID);

    String getValueNow(int parameterID);

    int update(HashMap map);
}