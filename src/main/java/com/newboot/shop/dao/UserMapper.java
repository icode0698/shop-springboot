package com.newboot.shop.dao;

import com.newboot.shop.model.User;
import com.newboot.shop.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String user);

    int insert(User row);

    int insertSelective(User row);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String user);

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);

    int updateCurrentTimeByUser(User user);
}