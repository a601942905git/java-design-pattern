package com.design.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * com.design.pattern.observer.jdk.Student2
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午10:41
 */
public class Student2 implements Observer {

    private Teacher teacher;

    public Student2(Teacher teacher) {
        this.teacher = teacher;
        this.teacher.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("老师第" + arg + "道数学题我听懂了。。。");
    }
}
