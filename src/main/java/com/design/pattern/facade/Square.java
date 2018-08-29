package com.design.pattern.facade;

/**
 * com.design.pattern.facade.Square
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午4:26
 */
public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a square");
    }
}
