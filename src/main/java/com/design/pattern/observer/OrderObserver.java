package com.design.pattern.observer;

/**
 * com.design.pattern.observer.Observer
 *
 * @author lipeng
 * @dateTime 2018/8/27 上午11:18
 */
public abstract class OrderObserver {

    protected OrderSubject orderSubject;

    public abstract void update();
}
