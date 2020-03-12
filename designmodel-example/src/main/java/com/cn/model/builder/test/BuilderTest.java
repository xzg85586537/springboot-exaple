package com.cn.model.builder.test;

import com.cn.model.builder.build.ConcerteBuilder;
import com.cn.model.builder.build.Director;
import com.cn.model.builder.build.ProductBuilder;
import com.cn.model.builder.entity.Product;

/**
 * @program:springboot-exaple
 * @description:测试
 * @author: xiao
 * @create:2020-03-09 19:39
 **/
public class BuilderTest {
    public static void main(String[] args) {
        ConcerteBuilder builder = new ConcerteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);

    }
}
