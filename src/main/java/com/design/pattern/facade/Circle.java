package com.design.pattern.facade;

/**
 * com.design.pattern.facade.Circle
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午4:27
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a circle");
    }
}
