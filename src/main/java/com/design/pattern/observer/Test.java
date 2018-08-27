package com.design.pattern.observer;

/**
 * com.design.pattern.observer.Test
 *
 * @author lipeng
 * @dateTime 2018/8/27 上午11:42
 */
public class Test {

    public static void main(String[] args) {
        OrderSubject orderSubject = new OrderSubject();

        new SmsObserver(orderSubject);
        new StockObserver(orderSubject);
        new ShoppingCartObserver(orderSubject);

        orderSubject.addOrder();
    }
}
