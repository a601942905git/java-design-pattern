package com.design.pattern.factory;

import com.design.pattern.factory.ab.ColorConstants;
import com.design.pattern.factory.simple.ShapeConstants;

/**
 * com.design.pattern.factory.Test
 *
 * @author lipeng
 * @dateTime 2018/8/26 下午9:41
 */
public class Test {

    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.draw(ShapeConstants.CIRCLE, ColorConstants.GREEN);
        draw.draw(ShapeConstants.SQUARE, ColorConstants.RED);
        draw.draw(ShapeConstants.RECTANGLE, ColorConstants.YELLOW);
    }
}
