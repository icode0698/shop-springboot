package com.newboot.shop.dao;

import com.newboot.shop.model.Message;
import com.newboot.shop.model.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message row);

    int insertSelective(Message row);

    List<Message> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Message row, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("row") Message row, @Param("example") MessageExample example);

    int updateByExample(@Param("row") Message row, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message row);

    int updateByPrimaryKeyWithBLOBs(Message row);

    int updateByPrimaryKey(Message row);
}