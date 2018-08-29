package com.design.pattern.facade;

/**
 * com.design.pattern.facade.ShapeMarker
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午4:30
 */
public class ShapeMarker {

    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public ShapeMarker() {
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawRectAngle() {
        rectangle.draw();
    }

    public void draw() {
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}
