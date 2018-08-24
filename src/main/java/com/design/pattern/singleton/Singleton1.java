package com.design.pattern.singleton;

/**
 * com.design.pattern.singleton.Singleton1
 * 单例饿汉实现方式
 * @author lipeng
 * @dateTime 2018/8/25 上午1:36
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
