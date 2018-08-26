package com.design.pattern.factory;

import com.design.pattern.factory.ab.Color;
import com.design.pattern.factory.simple.Shape;

/**
 * com.design.pattern.factory.Draw
 *
 * @author lipeng
 * @dateTime 2018/8/26 下午9:31
 */
public class Draw {

    public void draw(String shapeParam, String colorParam) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryConstants.SHAPE_FACTORY);
        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryConstants.COLOR_FACTORY);

        Shape shape = shapeFactory.getShape(shapeParam);
        Color color = colorFactory.getColor(colorParam);

        System.out.println(String.format("is drawing,%s的%s", color.show(), shape.show()));
    }
}
