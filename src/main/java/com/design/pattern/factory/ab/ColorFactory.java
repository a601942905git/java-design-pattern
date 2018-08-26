package com.design.pattern.factory.ab;

import com.design.pattern.factory.AbstractFactory;
import com.design.pattern.factory.simple.Shape;

import java.util.Objects;

/**
 * com.design.pattern.factory.ab.ColorFactory
 *
 * @author lipeng
 * @dateTime 2018/8/26 下午8:52
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorParam) {
        Color color = null;
        if (Objects.isNull(colorParam) || "".equals(colorParam)) {
            return color;
        } else if (Objects.equals(colorParam, ColorConstants.RED)) {
            return new Red();
        } else if (Objects.equals(colorParam, ColorConstants.YELLOW)) {
            return new Yellow();
        } else if (Objects.equals(colorParam, ColorConstants.GREEN)) {
            return new Green();
        }
        return color;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
