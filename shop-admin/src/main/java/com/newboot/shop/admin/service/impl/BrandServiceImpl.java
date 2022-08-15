package com.newboot.shop.admin.service.impl;

import com.newboot.shop.admin.dao.BrandMapper;
import com.newboot.shop.admin.model.Brand;
import com.newboot.shop.admin.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public int getBrandNow() {
        return brandMapper.getBrandNow();
    }

    @Override
    public int insert(HashMap map) {
        return 0;
    }

    @Override
    public ArrayList<Brand> select(HashMap map) {
        return brandMapper.select(map);
    }

    @Override
    public int update(HashMap map) {
        return brandMapper.update(map);
    }
}
