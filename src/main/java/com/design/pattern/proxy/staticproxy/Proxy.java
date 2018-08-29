package com.design.pattern.proxy.staticproxy;

import com.design.pattern.proxy.UserService;

/**
 * com.design.pattern.proxy.staticproxy.Proxy
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:00
 */
public class Proxy implements UserService {

    private UserService userService;

    public Proxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("在目标方法开始前增强");
        userService.sayHello(name);
        System.out.println("在目标方法结束后增强");
    }
}
