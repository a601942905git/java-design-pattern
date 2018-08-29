### 外观模式
- 描述
> 隐藏内部复杂的实现细节，对外面暴露最简单的接口
- 实例
    - 接口
    ```
    public interface Shape {

        void draw();
    }
    ```
    - 实现类
    ```
    public class Square implements Shape{

        @Override
        public void draw() {
            System.out.println("draw a square");
        }
    }
    
    public class Circle implements Shape{

        @Override
        public void draw() {
            System.out.println("draw a circle");
        }
    }
    
    public class Rectangle implements Shape{
    
        @Override
        public void draw() {
            System.out.println("draw a rectangle");
        }
    }
    ```
    - 外观模式类
    ```
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
    ```
    - 测试
    ```
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
    ```