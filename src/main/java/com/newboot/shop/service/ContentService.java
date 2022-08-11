package com.newboot.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.model.Comment;
import com.newboot.shop.model.Details;

import java.util.ArrayList;
import java.util.HashMap;

public interface ContentService {
    JSONObject getList(String categoryName);

    ArrayList<Details> getDetails(int goodsID);

    JSONObject getPrice(HashMap map);

    ArrayList<Comment> getComment(HashMap map);


}
