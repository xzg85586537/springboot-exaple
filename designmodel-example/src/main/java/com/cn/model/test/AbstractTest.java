package com.cn.model.test;

/**
 * @author by xiao
 * @Classname AbstractTest
 * @Description
 * @Date 2020-04-07 22:13
 */
public abstract class AbstractTest implements TestA {
    @Override
    public void add() {
        System.out.println("只重新add方法");
    }
}
