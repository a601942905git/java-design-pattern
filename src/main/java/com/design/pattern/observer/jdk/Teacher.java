package com.design.pattern.observer.jdk;

import java.util.Observable;

/**
 * com.design.pattern.observer.jdk.Teacher
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午10:38
 */
public class Teacher extends Observable {

    public void ask() {
        Integer number = 10;
        System.out.println("第" + number +  "道数学题大家都听懂了嘛？？？");
        setChanged();
        notifyObservers(number);
    }
}
