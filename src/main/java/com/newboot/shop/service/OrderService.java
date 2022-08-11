package com.newboot.shop.service;

import java.util.HashMap;

public interface OrderService {
    int join(HashMap map);

    int purchase(HashMap map);
}
