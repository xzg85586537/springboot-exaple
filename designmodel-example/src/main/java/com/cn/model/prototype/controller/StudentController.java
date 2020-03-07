package com.cn.model.prototype.controller;


import com.cn.model.prototype.entity.Student;
import com.cn.model.prototype.entity.StudentFiles;
import com.cn.model.prototype.entity.StudentFilesPrototype;
import com.cn.model.prototype.entity.StudentPrototype;

/**
 * @program:springboot-exaple
 * @description:测试原型模式
 * @author: xiao
 * @create:2020-03-07 10:41
 **/
public class StudentController {
    public static void main(String[] args) {
        /*
        现在假设每个人都是计算机01班的，2019-5-5入学，并且2020-6-5毕业，
        可以为每个人都创建一份档案，也就是多次new这个StudentFiles对象，但是由于都是同一个班级的，入学和毕业时间基本是固定的。
        因此我们为了简化代码值创建一份档案，让其他人都指向了这份档案。
         */
//        StudentFiles studentFiles = new StudentFiles("计算机01班", "2019-5-5", "2020-6-5");
//        Student xiaohong = new Student("小红", 10, studentFiles);
//        Student xiaoming = new Student("小明", 12, studentFiles);
//        Student xiaobai = new Student("小白", 14, studentFiles);
//        //输出：Student(name=小红, age=10, studentFiles=StudentFiles(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5))
//        System.out.println("xiaohong:" + xiaohong.toString());
//        //输出：Student(name=小明, age=12, studentFiles=StudentFiles(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5))
//        System.out.println("xiaoming:" + xiaoming.toString());
//        //输出：Student(name=小白, age=14, studentFiles=StudentFiles(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5))
//        System.out.println("xiaobai:" + xiaobai.toString());


//        /*
//        现在小明想换班到计算机02班，那么就会导致小红和小白也调到计算机02班
//        这明显不符合逻辑，我们要求每一个人的档案是唯一的，那么解决办法就是使用原型模式
//         */
//        StudentFilesPrototype prototype = new StudentFilesPrototype("计算机01班", "2019-5-5", "2020-6-5");
//        StudentFilesPrototype xiaomingFiles = (StudentFilesPrototype) prototype.clone();
//        xiaomingFiles.setDepartment("计算机02班");
//        StudentPrototype xiaohong = new StudentPrototype("小红", 10, prototype);
//        StudentPrototype xiaoming = new StudentPrototype("小明", 12, xiaomingFiles);
//        StudentPrototype xiaobai = new StudentPrototype("小白", 14, prototype);
//        //输出：name=小红, age=10, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5)
//        System.out.println("xiaohong:" + xiaohong.toString());
//        //输出：name=小明, age=12, studentFiles=StudentFilesPrototype(department=计算机02班, admissionTime=2019-5-5, graduationTime=2020-6-5)
//        System.out.println("xiaoming:" + xiaoming.toString());
//        //输出：name=小白, age=14, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5)
//        System.out.println("xiaobai:" + xiaobai.toString());
//    }

        /*
         * 现在假设大部分人入学的时候年龄都是20岁，只有小红是15岁入学的。
         */
        StudentFilesPrototype prototype = new StudentFilesPrototype("计算机01班", "2019-5-5", "2020-6-5");
        StudentPrototype studentPrototype = new StudentPrototype(20);
        studentPrototype.setStudentFilesPrototype(prototype);
        StudentPrototype xiaohong = studentPrototype.clone();
        xiaohong.setName("小红");
        xiaohong.setAge(15);
        StudentPrototype xiaoming = studentPrototype.clone();
        xiaoming.setName("小明");
        StudentPrototype xiaobai = studentPrototype.clone();
        xiaobai.setName("小白");
        //输出：name=小红, age=15, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5)
        System.out.println("xiaohong:" + xiaohong.toString());
        //输出：name=小明, age=20, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5)
        System.out.println("xiaoming:" + xiaoming.toString());
        //输出：name=小白, age=20, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-6-5)
        System.out.println("xiaobai:" + xiaobai.toString());

        //现在小明由于太过聪明，提前一个月毕业，那么修改小明的毕业日期为2020-5-5
        StudentFilesPrototype files = xiaoming.getStudentFilesPrototype();
        files.setGraduationTime("2020-5-5");
        xiaoming.setStudentFilesPrototype(files);
        //输出：name=小明, age=20, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-5-5)
        System.out.println("xiaoming2:" + xiaoming.toString());
        //输出：name=小红, age=15, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-5-5)
        System.out.println("xiaohong2:" + xiaohong.toString());
        //输出：name=小白, age=20, studentFiles=StudentFilesPrototype(department=计算机01班, admissionTime=2019-5-5, graduationTime=2020-5-5)
        System.out.println("xiaobai2:" + xiaobai.toString());
        /*
        很明显，我们只允许小明提前毕业，但是小红和小白也跟着提前毕业了。
         */
        /**
         * 这就是浅拷贝与深拷贝的区别：
         * StudentPrototype里面有int、String、StudentFilesPrototype对象属性。
         * 浅拷贝：只拷贝基本数据类型，而对于对象属性则拷贝其中的引用地址，因此导致3个人都提前毕业的情况。
         * 深拷贝：基本属性类型和对象都拷贝一份。
         * 现在我们在StudentPrototype新增了代码：
         * prototype.setStudentFilesPrototype((StudentFilesPrototype) studentFilesPrototype.clone());
         * 以上就能实现深拷贝
         */
    }

}
