package com.design.pattern.factory.simple;

import com.design.pattern.factory.AbstractFactory;
import com.design.pattern.factory.ab.Color;

import java.util.Objects;

/**
 * com.design.pattern.factory.simple.ShapeFactory
 *
 * @author lipeng
 * @dateTime 2018/8/25 下午9:02
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeParam) {
        Shape shape = null;
        if (Objects.isNull(shapeParam) || "".equals(shapeParam)) {
            return shape;
        } else if (Objects.equals(shapeParam, ShapeConstants.CIRCLE)) {
            return new Circle();
        } else if (Objects.equals(shapeParam, ShapeConstants.RECTANGLE)) {
            return new Rectangle();
        } else if (Objects.equals(shapeParam, ShapeConstants.SQUARE)) {
            return new Square();
        }
        return shape;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
