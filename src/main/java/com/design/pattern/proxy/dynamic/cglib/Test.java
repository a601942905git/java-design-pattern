package com.design.pattern.proxy.dynamic.cglib;

/**
 * com.design.pattern.proxy.dynamic.cglib.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:16
 */
public class Test {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new StudentService());
        StudentService studentService = (StudentService) proxyFactory.getInstance();
        studentService.doHomeWork("张三");

        System.out.println("\n");

        proxyFactory = new ProxyFactory(new TeacherService());
        TeacherService teacherService = (TeacherService) proxyFactory.getInstance();
        teacherService.teach("王");
    }
}
