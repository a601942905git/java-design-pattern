package com.design.pattern.singleton;

/**
 * com.design.pattern.singleton.Singleton3
 * 静态内部类
 * @author lipeng
 * @dateTime 2018/8/25 上午1:43
 */
public class Singleton3 {

    private Singleton3() {

    }

    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
