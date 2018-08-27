package com.design.pattern.observer;

/**
 * com.design.pattern.observer.StockObserver
 * 库存观察者
 * @author lipeng
 * @dateTime 2018/8/27 上午11:29
 */
public class StockObserver extends OrderObserver{

    public StockObserver (OrderSubject orderSubject) {
        this.orderSubject = orderSubject;
        this.orderSubject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("扣减库存。。。。。。");
    }
}
