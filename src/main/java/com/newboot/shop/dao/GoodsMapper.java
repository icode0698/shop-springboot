package com.newboot.shop.dao;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.model.Goods;
import com.newboot.shop.model.GoodsExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsID);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsID);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    ArrayList<JSONObject> getList(HashMap map);

    ArrayList<String> getImgListBySpu(Integer spu);

}