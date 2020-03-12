package com.cn.model.builder.build;

import com.cn.model.builder.entity.Product;

/**
 * @program:springboot-exaple
 * @description:建造者模式
 * @author: xiao
 * @create:2020-03-09 19:37
 **/
public class ConcerteBuilder extends ProductBuilder {


    @Override
    ProductBuilder buildA() {
        product.setBulidA("步骤A");
        System.out.println("步骤A");
        return this;
    }

    @Override
    ProductBuilder buildB() {
        product.setBulidB("步骤B");
        System.out.println("步骤B");
        return this;
    }

    @Override
    ProductBuilder buildC() {
        product.setBulidC("步骤D");
        System.out.println("步骤C");
        return this;
    }

    @Override
    ProductBuilder buildD() {
        product.setBulidD("步骤D");
        System.out.println("步骤D");
        return this;
    }
}
