package com.design.pattern.facade;

/**
 * com.design.pattern.facade.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午4:28
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 在不适用外观模式情况下，要画出正方形、长方形、圆形就要创建3个对象
         * 然后分别调用对象
         */
        /*Shape square = new Square();
        square.draw();

        Shape circle = new Circle();
        circle.draw();

        Shape rectangle = new Rectangle();
        rectangle.draw();*/

        ShapeMarker shapeMarker = new ShapeMarker();
        shapeMarker.draw();

        System.out.println("\n");

        shapeMarker.drawCircle();
        shapeMarker.drawRectAngle();
        shapeMarker.drawSquare();
    }
}
