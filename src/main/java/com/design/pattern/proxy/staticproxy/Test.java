package com.design.pattern.proxy.staticproxy;

import com.design.pattern.proxy.UserServiceImpl;

/**
 * com.design.pattern.proxy.staticproxy.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:06
 */
public class Test {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new UserServiceImpl());
        proxy.sayHello("张三");
    }
}
