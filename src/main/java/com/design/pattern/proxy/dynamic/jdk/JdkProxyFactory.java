package com.design.pattern.proxy.dynamic.jdk;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * com.design.pattern.proxy.dynamic.jdk.JdkProxyFactory
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:28
 */
public class JdkProxyFactory {

    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("在目标方法开始前增强");
                    Object result = method.invoke(target, args);
                    System.out.println("在目标方法结束后增强");
                    return result;
                });
    }
}
