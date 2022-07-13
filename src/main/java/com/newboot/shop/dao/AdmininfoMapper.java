package com.newboot.shop.dao;

import com.newboot.shop.model.Admininfo;
import com.newboot.shop.model.AdmininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmininfoMapper {
    long countByExample(AdmininfoExample example);

    int deleteByExample(AdmininfoExample example);

    int deleteByPrimaryKey(String type);

    int insert(Admininfo row);

    int insertSelective(Admininfo row);

    List<Admininfo> selectByExampleWithBLOBs(AdmininfoExample example);

    List<Admininfo> selectByExample(AdmininfoExample example);

    Admininfo selectByPrimaryKey(String type);

    int updateByExampleSelective(@Param("row") Admininfo row, @Param("example") AdmininfoExample example);

    int updateByExampleWithBLOBs(@Param("row") Admininfo row, @Param("example") AdmininfoExample example);

    int updateByExample(@Param("row") Admininfo row, @Param("example") AdmininfoExample example);

    int updateByPrimaryKeySelective(Admininfo row);

    int updateByPrimaryKeyWithBLOBs(Admininfo row);
}