package com.design.pattern.singleton;

/**
 * com.design.pattern.singleton.Singleton2
 * 懒汉双重锁实现方式
 * @author lipeng
 * @dateTime 2018/8/25 上午1:37
 */
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (null == instance) {
            synchronized (Singleton2.class) {
                if (null == instance) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
