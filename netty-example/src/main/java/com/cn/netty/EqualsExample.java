package com.cn.netty;

import java.util.Objects;

/**
 * @author by xiao
 * @Classname EqualsExample
 * @Description
 * @Date 2020/1/9 15:29
 * 重写equals和hashcode方法
 */
public class EqualsExample {
    private Integer id;
    private String name;
    private Double salary;

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        //判断this和Object是否引用同一个对象
        if (this == otherObject) {
            return true;
        }
        //判断this和Object是否属于同一个类
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        //如果都一样了，就用instanceof进行检测
        if (!(otherObject instanceof EqualsExample)) {
            return false;
        }
        //转成相应的类型变量
        EqualsExample example = (EqualsExample) otherObject;
        return Objects.equals(id, example.id) && name == example.name && Objects.equals(salary, example.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
