package com.design.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * com.design.pattern.observer.jdk.Student3
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午10:41
 */
public class Student3 implements Observer {

    private Teacher teacher;

    public Student3(Teacher teacher) {
        this.teacher = teacher;
        this.teacher.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("老师第" + arg + "道数学题我也没有听懂？？？");
    }
}
