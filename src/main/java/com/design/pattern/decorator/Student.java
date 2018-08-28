package com.design.pattern.decorator;

/**
 * com.design.pattern.decorator.Student
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午9:41
 */
public class Student implements Person{

    @Override
    public void sayHello() {
        System.out.println("我是一个学生");
    }
}
