package com.design.pattern.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * com.design.pattern.proxy.dynamic.cglib.ProxyFactory
 *
 * @author lipeng
 * @dateTime 2018/8/29 上午11:10
 */
public class ProxyFactory implements MethodInterceptor {

    /**
     * 持有目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("在目标方法开始前增强");
        result = method.invoke(target, objects);
        System.out.println("在目标方法结束后增强");
        return result;
    }
}
