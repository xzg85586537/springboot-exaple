package com.cn.common.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @program:springboot-exaple
 * @description:将data转成list
 * @author: xiao
 * @create:2020-03-12 15:09
 **/
public class DataList {
    /**
     * 第一个参数的data是个json字符串，里面可以嵌套多层，
     * 第二个为具体类。
     * @param data
     * @param entity
     * @param <T>
     * @return
     */
    private <T> List<T> dataToList(String data, Class<T> entity) {
        JSON jsonData = JSONUtil.parse(data);
        List<T> entities = new ArrayList();
        if (jsonData instanceof JSONArray) {
            JSONArray array = JSONUtil.parseArray(data);
            for (Object o : array) {
                T t = JSONUtil.toBean(JSONUtil.parseObj(o), entity);
                entities.add(t);
            }
            // 有两层集合
//            entities = (List<T>) JSONUtil.toList(JSONUtil.parseArray(jsonData), ArrayList.class);
//            entities = JSONUtil.toBean(data, ArrayList.class);
        } else if (jsonData instanceof JSONObject) {
            T entityData = JSONUtil.toBean(data, entity);
            entities.add(entityData);
        }
        return entities;
    }
}
