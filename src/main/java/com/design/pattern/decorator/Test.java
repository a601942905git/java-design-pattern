package com.design.pattern.decorator;

/**
 * com.design.pattern.decorator.Test
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午9:53
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.sayHello();

        Teacher teacher = new Teacher();
        teacher.sayHello();
        System.out.println("\n");

        FunctionStudentDecorator functionStudentDecorator = new FunctionStudentDecorator(new Student());
        functionStudentDecorator.sayHello();
        System.out.println("\n");

        FunctionTeacherDecorator functionTeacherDecorator = new FunctionTeacherDecorator(new Teacher());
        functionTeacherDecorator.sayHello();

    }
}
