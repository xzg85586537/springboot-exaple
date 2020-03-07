package com.cn.model.prototype.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:springboot-exaple
 * @description:使用原型模式的学生实体类
 * @author: xiao
 * @create:2020-03-07 16:57
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPrototype implements Cloneable {
    private String name;
    private int age;
    private StudentFilesPrototype studentFilesPrototype;

    public StudentPrototype(int age) {
        this.age = age;
    }

    @Override
    public StudentPrototype clone() {
        StudentPrototype prototype = null;
        try {
            prototype = (StudentPrototype) super.clone();
            //深拷贝 对于对象类型进行拷贝
            prototype.setStudentFilesPrototype((StudentFilesPrototype) studentFilesPrototype.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
