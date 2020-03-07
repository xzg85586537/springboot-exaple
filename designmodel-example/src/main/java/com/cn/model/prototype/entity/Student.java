package com.cn.model.prototype.entity;

import lombok.*;

/**
 * @program:springboot-exaple
 * @description:学生实体类
 * @author: xiao
 * @create:2020-03-07 10:36
 * <p>
 * 以下就是原型模式的使用，实体类只需要实现Cloneable接口，然后重写clone方法即可，将protected修改成public，并且抛出异常
 * 作用场景：需要重复创建大量相同或者相似的对象问题
 * 如在for循环中可能会多次创建，那么就可以使用原型模式了。
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private StudentFiles studentFiles;
}
