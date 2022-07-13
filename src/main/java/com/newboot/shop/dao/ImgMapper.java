package com.newboot.shop.dao;

import com.newboot.shop.model.Img;
import com.newboot.shop.model.ImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgMapper {
    long countByExample(ImgExample example);

    int deleteByExample(ImgExample example);

    int deleteByPrimaryKey(Integer imgid);

    int insert(Img row);

    int insertSelective(Img row);

    List<Img> selectByExample(ImgExample example);

    Img selectByPrimaryKey(Integer imgid);

    int updateByExampleSelective(@Param("row") Img row, @Param("example") ImgExample example);

    int updateByExample(@Param("row") Img row, @Param("example") ImgExample example);

    int updateByPrimaryKeySelective(Img row);

    int updateByPrimaryKey(Img row);
}