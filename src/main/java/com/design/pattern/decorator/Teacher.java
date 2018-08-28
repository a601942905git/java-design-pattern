package com.design.pattern.decorator;

/**
 * com.design.pattern.decorator.Teacher
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午9:41
 */
public class Teacher implements Person{

    @Override
    public void sayHello() {
        System.out.println("我是一个教师");
    }
}
