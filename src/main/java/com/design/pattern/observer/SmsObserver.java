package com.design.pattern.observer;

/**
 * com.design.pattern.observer.SmsObserver
 * 短信观察者
 * @author lipeng
 * @dateTime 2018/8/27 上午11:29
 */
public class SmsObserver extends OrderObserver{

    public SmsObserver(OrderSubject orderSubject) {
        this.orderSubject = orderSubject;
        this.orderSubject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("发送短信。。。。。。");
    }
}
