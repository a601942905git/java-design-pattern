package com.design.pattern.proxy.dynamic.cglib;

/**
 * com.design.pattern.proxy.dynamic.cglib.TeacherService
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:25
 */
public class TeacherService {

    public void teach(String name) {
        System.out.println(String.format("%s老师正在授课", name));
    }

}
