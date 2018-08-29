package com.design.pattern.proxy.dynamic.cglib;

/**
 * com.design.pattern.proxy.dynamic.cglib.StudentService
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:09
 */
public class StudentService {

    public void doHomeWork(String name) {
        System.out.println(String.format("%s正在写家庭作业", name));
    }
}
