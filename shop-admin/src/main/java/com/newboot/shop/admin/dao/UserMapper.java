package com.newboot.shop.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.model.User;
import com.newboot.shop.admin.model.UserExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String user);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String user);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    ArrayList<JSONObject> getList(HashMap map);

    int offline(HashMap map);
}