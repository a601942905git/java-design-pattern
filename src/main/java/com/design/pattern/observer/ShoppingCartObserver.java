package com.design.pattern.observer;

/**
 * com.design.pattern.observer.ShoppingCartObserver
 * 购物车观察者
 * @author lipeng
 * @dateTime 2018/8/27 上午11:31
 */
public class ShoppingCartObserver extends OrderObserver{

    public ShoppingCartObserver(OrderSubject orderSubject) {
        this.orderSubject = orderSubject;
        this.orderSubject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("清空购物车商品信息。。。。。。");
    }
}
