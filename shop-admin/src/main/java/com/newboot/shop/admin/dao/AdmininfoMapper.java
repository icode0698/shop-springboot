package com.newboot.shop.admin.dao;

import com.newboot.shop.admin.model.Admininfo;
import com.newboot.shop.admin.model.AdmininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmininfoMapper {
    long countByExample(AdmininfoExample example);

    int deleteByExample(AdmininfoExample example);

    int deleteByPrimaryKey(String type);

    int insert(Admininfo record);

    int insertSelective(Admininfo record);

    List<Admininfo> selectByExampleWithBLOBs(AdmininfoExample example);

    List<Admininfo> selectByExample(AdmininfoExample example);

    Admininfo selectByPrimaryKey(String type);

    int updateByExampleSelective(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByExample(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByPrimaryKeySelective(Admininfo record);

    int updateByPrimaryKeyWithBLOBs(Admininfo record);
}