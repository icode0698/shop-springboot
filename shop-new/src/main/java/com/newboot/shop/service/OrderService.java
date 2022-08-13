package com.newboot.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.model.Shop;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderService {
    int join(HashMap map);

    int purchase(HashMap map);

    ArrayList<Shop> getTrolleyList(HashMap map);

    ArrayList<Shop> getOrderList(HashMap map);

    int trolleySettlement(JSONObject json);

    int trolleyDelete(HashMap map);

    int delete(HashMap map);

    JSONObject getOrderInfo(HashMap map);
}
