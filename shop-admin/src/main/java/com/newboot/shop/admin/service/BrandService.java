package com.newboot.shop.admin.service;

import com.newboot.shop.admin.model.Brand;

import java.util.ArrayList;
import java.util.HashMap;

public interface BrandService {
    int getBrandNow();

    int insert(HashMap map);

    ArrayList<Brand> select(HashMap map);

    int update(HashMap map);
}
