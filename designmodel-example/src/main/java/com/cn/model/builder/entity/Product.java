package com.cn.model.builder.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program:springboot-exaple
 * @description:建造者模式
 * @author: xiao
 * @create:2020-03-09 19:32
 **/
@Getter
@Setter
@ToString
public class Product {
    private String bulidA;
    private String bulidB;
    private String bulidC;
    private String bulidD;
}
