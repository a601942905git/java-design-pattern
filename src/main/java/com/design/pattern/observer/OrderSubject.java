package com.design.pattern.observer;

import java.util.ArrayList;

/**
 * com.design.pattern.observer.Subject
 * 订单目标对象
 * @author lipeng
 * @dateTime 2018/8/27 上午11:16
 */
public class OrderSubject {

    private ArrayList<OrderObserver> observerList = new ArrayList<>();

    public void addOrder() {
        System.out.println("下订单。。。。。。");
        notifyAllObservers();
    }

    public void addObserver(OrderObserver observer) {
        observerList.add(observer);
    }

    /**
     * 通知所有的观察者
     */
    private void notifyAllObservers() {
        for (OrderObserver observer : observerList) {
            observer.update();
        }
    }
}
