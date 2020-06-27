package com.cn.model.test;

/**
 * @author by xiao
 * @Classname TestB
 * @Description
 * @Date 2020-04-07 22:16
 *
 * A类有2个接口，现在定义了一个抽象类C，C类实现了A类，这个抽象类只重写了一个方法，
 * 现在的话B类继承了抽象类C，由于A类还有一个接口没有完成，因此B类需要实现。也就是说如果一个类继承了抽象类，
 * 这个抽象类实现了相关的接口，那么这个类就要把抽象类未完成的方法完成。
 */
public class TestB extends AbstractTest {
    @Override
    public void delete() {

    }
}
