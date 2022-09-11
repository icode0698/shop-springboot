package com.newboot.shop.admin.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.model.Img;
import com.newboot.shop.admin.model.ImgExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ImgMapper {
    long countByExample(ImgExample example);

    int deleteByExample(ImgExample example);

    int deleteByPrimaryKey(Integer imgID);

    int insertSelective(Img record);

    List<Img> selectByExample(ImgExample example);

    Img selectByPrimaryKey(Integer imgID);

    int updateByExampleSelective(@Param("record") Img record, @Param("example") ImgExample example);

    int updateByExample(@Param("record") Img record, @Param("example") ImgExample example);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);

    int getSpuImgNow();

    int insert(HashMap map);

    int delete(HashMap map);
}