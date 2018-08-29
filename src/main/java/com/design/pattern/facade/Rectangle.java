package com.design.pattern.facade;

/**
 * com.design.pattern.facade.Rectangle
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午4:27
 */
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }
}
