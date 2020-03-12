package com.cn.model.builder.build;

import com.cn.model.builder.entity.Product;

/**
 * @program:springboot-exaple
 * @description:
 * @author: xiao
 * @create:2020-03-09 19:49
 **/
public class Director {
    private ProductBuilder productBuilder;

    public Director(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product construct() {
        productBuilder.buildA();
        productBuilder.buildB();
        productBuilder.buildC();
        productBuilder.buildD();
        return productBuilder.getProduct();
    }
}
