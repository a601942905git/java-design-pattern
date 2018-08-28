package com.design.pattern.observer.jdk;

/**
 * com.design.pattern.observer.jdk.Test
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午10:42
 */
public class Test {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        new Student1(teacher);
        new Student2(teacher);
        new Student3(teacher);

        teacher.ask();
    }
}
