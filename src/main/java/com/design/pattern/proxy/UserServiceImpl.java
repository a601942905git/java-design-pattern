package com.design.pattern.proxy;

/**
 * com.design.pattern.proxy.UserServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午11:31
 */
public class UserServiceImpl implements UserService {

    @Override
    public void sayHello(String name) {
        System.out.println(String.format("Hello,My Name Is%s", name));
    }
}
