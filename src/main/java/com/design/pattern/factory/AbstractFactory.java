package com.design.pattern.factory;

import com.design.pattern.factory.ab.Color;
import com.design.pattern.factory.simple.Shape;

/**
 * com.design.pattern.factory.AbstractFactory
 *
 * @author lipeng
 * @dateTime 2018/8/26 下午8:59
 */
public abstract class AbstractFactory {

    /**
     * 获取形状
     * @param shape
     * @return
     */
    public abstract Shape getShape(String shape);

    /**
     * 获取颜色
     * @param color
     * @return
     */
    public abstract Color getColor(String color);
}
