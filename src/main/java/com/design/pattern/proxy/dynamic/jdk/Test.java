package com.design.pattern.proxy.dynamic.jdk;

import com.design.pattern.proxy.UserService;
import com.design.pattern.proxy.UserServiceImpl;

/**
 * com.design.pattern.proxy.dynamic.jdk.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:34
 */
public class Test {

    public static void main(String[] args) {
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(new UserServiceImpl());
        UserService userService = (UserService) jdkProxyFactory.getInstance();
        userService.sayHello("李四");
    }
}
