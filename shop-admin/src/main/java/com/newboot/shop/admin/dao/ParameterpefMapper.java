package com.newboot.shop.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.model.Parameterpef;
import com.newboot.shop.admin.model.ParameterpefExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ParameterpefMapper {
    long countByExample(ParameterpefExample example);

    int deleteByExample(ParameterpefExample example);

    int deleteByPrimaryKey(Integer valueID);

    int insertSelective(Parameterpef record);

    List<Parameterpef> selectByExample(ParameterpefExample example);

    Parameterpef selectByPrimaryKey(Integer valueID);

    int updateByExampleSelective(@Param("record") Parameterpef record, @Param("example") ParameterpefExample example);

    int updateByExample(@Param("record") Parameterpef record, @Param("example") ParameterpefExample example);

    int updateByPrimaryKeySelective(Parameterpef record);

    int updateByPrimaryKey(Parameterpef record);

    ArrayList<JSONObject> getParameterValueByID(HashMap map);

    String getValueNow(HashMap map);

    int update(HashMap map);

    int insert(HashMap map);
}