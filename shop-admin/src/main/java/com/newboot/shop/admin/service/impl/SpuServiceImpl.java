package com.newboot.shop.admin.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.newboot.shop.admin.dao.*;
import com.newboot.shop.admin.model.Parameter;
import com.newboot.shop.admin.service.SpuService;
import com.newboot.shop.admin.util.MybatisBatchUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@Service
@EnableAsync
public class SpuServiceImpl implements SpuService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ParameterpefMapper parameterpefMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    ParameterMapper parameterMapper;
    @Autowired
    ImgMapper imgMapper;
    @Autowired
    GoodspefMapper goodspefMapper;
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public JSONObject getSpuNow() {
        JSONObject json = new JSONObject();
        json.put("spuNow", goodsMapper.getSpuNow());
        json.put("categoryList", categoryMapper.select());
        json.put("brandList", brandMapper.select());
        ArrayList<Parameter> parameterList = parameterMapper.getParameter();
        HashMap map = new HashMap();
        map.put("parameterID", parameterList.get(0).getParameterID());
        json.put("storageList", parameterpefMapper.getParameterValueByID(map));
        map.put("parameterID", parameterList.get(1).getParameterID());
        json.put("colorList", parameterpefMapper.getParameterValueByID(map));
        map.put("parameterID", parameterList.get(2).getParameterID());
        json.put("screenList", parameterpefMapper.getParameterValueByID(map));
        return json;
    }

    @Override
    public int getSpuImgNow() {
        return imgMapper.getSpuImgNow();
    }

    @Override
    public int insert(HashMap map) {
        long begin = Instant.now().toEpochMilli();
        if (goodsMapper.insert(map) > 0) {
            imgMapper.insert(map);
            JSONObject json = new JSONObject(map);
            int goodsID = json.getInteger("goodsID");
            int spIDNow = goodspefMapper.getSpIDNow();
            int skuNow = priceMapper.getSkuNow();
            JSONArray storageArray = json.getJSONArray("storageList");
            JSONArray colorArray = json.getJSONArray("colorList");
            JSONArray screenArray = json.getJSONArray("screenList");
            ArrayList<Parameter> parameterList = parameterMapper.getParameter();
            int storageID = parameterList.get(0).getParameterID();
            int colorID = parameterList.get(1).getParameterID();
            int screenID = parameterList.get(2).getParameterID();
            ArrayList<Integer> storageIDList = new ArrayList<>();
            ArrayList<Integer> colorIDList = new ArrayList<>();
            ArrayList<Integer> screenIDList = new ArrayList<>();
            ArrayList<HashMap> pefList = new ArrayList<>();
            ArrayList<HashMap> spuList = new ArrayList<>();
            for (int i = 0; i < storageArray.size(); i++) {
                HashMap temp = new HashMap();
                temp.put("spID", ++spIDNow);
                temp.put("goodsID", goodsID);
                temp.put("valueID", storageArray.getIntValue(i));
                temp.put("parameterID", storageID);
                pefList.add(temp);
                storageIDList.add(spIDNow);
            }
            for (int i = 0; i < colorArray.size(); i++) {
                HashMap temp = new HashMap();
                temp.put("spID", ++spIDNow);
                temp.put("goodsID", goodsID);
                temp.put("valueID", colorArray.getIntValue(i));
                temp.put("parameterID", colorID);
                pefList.add(temp);
                colorIDList.add(spIDNow);
            }
            for (int i = 0; i < screenArray.size(); i++) {
                HashMap temp = new HashMap();
                temp.put("spID", ++spIDNow);
                temp.put("goodsID", goodsID);
                temp.put("valueID", screenArray.getIntValue(i));
                temp.put("parameterID", screenID);
                pefList.add(temp);
                screenIDList.add(spIDNow);
            }
            // 批处理插入大量数据
            long sValue = Instant.now().toEpochMilli();
            threadPoolTaskExecutor.execute(() ->
                    MybatisBatchUtil.batchUpdateOrInsert(pefList, GoodspefMapper.class, (item, goodspefMapper) -> goodspefMapper.insert(item)));
            log.info("batisTime: {}", (Instant.now().toEpochMilli() - sValue) / 1000D);
            for (int i = 0; i < storageIDList.size(); i++) {
                for (int j = 0; j < colorIDList.size(); j++) {
                    for (int k = 0; k < screenIDList.size(); k++) {
                        HashMap temp = new HashMap();
                        temp.put("sku", ++skuNow);
                        temp.put("goodsID", goodsID);
                        temp.put("spID1", storageIDList.get(i));
                        temp.put("spID2", colorIDList.get(j));
                        temp.put("spID3", screenIDList.get(k));
                        spuList.add(temp);
                    }
                }
            }
            // 批处理插入大量数据
            sValue = Instant.now().toEpochMilli();
            threadPoolTaskExecutor.execute(() ->
                    MybatisBatchUtil.batchUpdateOrInsert(spuList, PriceMapper.class, (item, priceMapper) -> priceMapper.insert(item)));
            log.info("batisTime: {}", (Instant.now().toEpochMilli() - sValue) / 1000D);
            log.info("totalMybatisTime: {} s", (Instant.now().toEpochMilli() - begin) / 1000D);
//            long sFor = Instant.now().toEpochMilli();
//            for (int i = 0; i < storageIDList.size(); i++) {
//                for (int j = 0; j < colorIDList.size(); j++) {
//                    for (int k = 0; k < screenIDList.size(); k++) {
//                        map = new HashMap();
//                        map.put("sku", ++skuNow);
//                        map.put("goodsID", json.getIntValue("goodsID"));
//                        map.put("spID1", storageIDList.get(i));
//                        map.put("spID2", colorIDList.get(j));
//                        map.put("spID3", screenIDList.get(k));
//                        spuList.add(map);
//                    }
//                }
//            }
//            // 并行流多线程
//            storageIDList.parallelStream().forEach(i->{
//                for (int j:colorIDList) {
//                    for (int k:screenIDList) {
//                        log.info("-----------------{}--------------", Thread.currentThread().getName());
//                        HashMap temp = new HashMap();
//                        temp.put("sku", RandomStringUtils.randomNumeric(8));
//                        temp.put("goodsID", goodsID);
//                        temp.put("spID1", i);
//                        temp.put("spID2", j);
//                        temp.put("spID3", k);
//                        spuList.add(temp);
//                    }
//                }
//            });
//            System.out.println((Instant.now().toEpochMilli()-sFor)/1000D);
//            long sBatis = Instant.now().toEpochMilli();
//            for (int i = 0; i < spuList.size(); i++) {
//                priceMapper.insert(spuList.get(i));
//            }
//            System.out.println((Instant.now().toEpochMilli()-sBatis)/1000D);
            return 1;
        }
        return -1;
    }

    @Override
    public ArrayList<JSONObject> select(HashMap map) {
        return goodsMapper.select(map);
    }

    @Override
    public int update(HashMap map) {
        return goodsMapper.update(map);
    }

    @Override
    public int delete(HashMap map) {
        long time = Instant.now().toEpochMilli();
        log.info("begin time: {}", Instant.now().toEpochMilli());
        threadPoolTaskExecutor.execute(() -> priceMapper.delete(map));
        threadPoolTaskExecutor.execute(() -> goodspefMapper.delete(map));
        threadPoolTaskExecutor.execute(() -> imgMapper.delete(map));
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> {
                    priceMapper.delete(map);
                }, threadPoolTaskExecutor),
                CompletableFuture.runAsync(() -> {
                    goodspefMapper.delete(map);
                    ;
                }, threadPoolTaskExecutor),
                CompletableFuture.runAsync(() -> {
                    imgMapper.delete(map);
                }, threadPoolTaskExecutor)
        );
        log.info("end time: {}", Instant.now().toEpochMilli());
        log.info("use time: {}", Instant.now().toEpochMilli() - time);
        return goodsMapper.delete(map);
    }
}
