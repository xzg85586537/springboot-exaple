package com.cn.model.prototype.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:springboot-exaple
 * @description: 使用原型模式的学生档案
 * @author: xiao
 * @create:2020-03-07 16:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFilesPrototype implements Cloneable {
    //院系
    private String department;
    //入学时间
    private String admissionTime;
    //毕业时间
    private String graduationTime;

    @Override
    public Object clone() {
        StudentFilesPrototype prototype = null;
        try {
            prototype = (StudentFilesPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
