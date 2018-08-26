package com.design.pattern.factory;

import com.design.pattern.factory.ab.ColorFactory;
import com.design.pattern.factory.simple.ShapeFactory;

import java.util.Objects;

/**
 * com.design.pattern.factory.FactoryProducer
 *
 * @author lipeng
 * @dateTime 2018/8/26 下午9:28
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String type) {
        AbstractFactory abstractFactory = null;
        if (Objects.isNull(type) || "".equals(type)) {
            return abstractFactory;
        } else if (Objects.equals(type, FactoryConstants.SHAPE_FACTORY)) {
            return new ShapeFactory();
        } else if (Objects.equals(type, FactoryConstants.COLOR_FACTORY)) {
            return new ColorFactory();
        }

        return abstractFactory;
    }
}
