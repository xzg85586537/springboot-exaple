package com.cn.model.builder.build;

import com.cn.model.builder.entity.Product;

/**
 * @program:springboot-exaple
 * @description:建造者模式
 * @author: xiao
 * @create:2020-03-09 19:34
 **/
public abstract class ProductBuilder {
    protected Product product = new Product();

    abstract ProductBuilder buildA();

    abstract ProductBuilder buildB();

    abstract ProductBuilder buildC();

    abstract ProductBuilder buildD();

    public Product getProduct() {
        return product;
    }
}
