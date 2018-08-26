### 工厂模式

#### 优点
> 隐藏创建对象的具体细节，调用者需要什么对象，就返回什么对象

#### 使用场景
> 需要使用到同一类型的多个对象

#### 实现方式

##### 简单工厂
- 作用
> 用来创建对象
- 场景描述
> 想要得到各种各样的形状，涉及到同一类型的多个对象。类型：形状，对象：长方形、圆形、正方形
- 思路
> 类型抽象为接口，对象实现接口，定义一个工厂，生产具体对象
- 实现
    - 接口
    ```
    public interface Shape {

        /**
         * 展现
         */
        String show();
    }
    ```
    - 实现对象
    ```
    public class Rectangle implements Shape{

        @Override
        public String show() {
            return "长方形";
        }
    }
    ```
    ```
    public class Square implements Shape{

        @Override
        public String show() {
            return "正方形";
        }
    }
    ```
    ```
    public class Circle implements Shape{
    
        @Override
        public String show() {
            return "圆形";
        }
    }
    ```
    - 常量类
    ```
    public class ShapeConstants {
    
        public static final String RECTANGLE = "rectangle";
    
        public static final String SQUARE = "square";
    
        public static final String CIRCLE = "circle";
    }
    ```
    - 生产对象的工厂
    ```
    public class ShapeFactory {

        public static Shape getShape(String type) {
            Shape shape = null;
            if (Objects.isNull(type) || "".equals(type)) {
                return shape;
            } else if (Objects.equals(type, ShapeConstants.CIRCLE)) {
                return new Circle();
            } else if (Objects.equals(type, ShapeConstants.RECTANGLE)) {
                return new Rectangle();
            } else if (Objects.equals(type, ShapeConstants.SQUARE)) {
                return new Square();
            }
            return shape;
        }
    }

    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            // 获取长方形
            Shape rectangle = ShapeFactory.getShape(ShapeConstants.RECTANGLE);
            System.out.println(rectangle.show());
    
            // 获取正方形
            Shape square = ShapeFactory.getShape(ShapeConstants.SQUARE);
            System.out.println(square.show());
    
            // 获取圆形
            Shape circle = ShapeFactory.getShape(ShapeConstants.CIRCLE);
            System.out.println(circle.show());
        }
    }
    ```

#### 抽象工厂
- 场景描述
> 抽象工厂通常用于组合对象得到结果的场景。例如：希望画出红色的长方形、绿色的圆形、黄色的正方形。涉及到形状和颜色，此时可以抽象出一个工厂用来生成形状，一个工厂用来生产颜色。然后在抽象出一个抽象工厂来持有形状工厂和颜色工厂。
- 结构
```
|- FactoryProducer 生产工厂
|- AbstractFactory 工厂抽象
    |- ColorFactory 颜色工厂
        |- Color 接口
            |- RedColor 接口实现
    |- ShapeFactory 形状工厂
        |- Shape 接口
            |- Rectangle 接口实现

```
- 实现
```
public interface Color {

    String show();
}

public class Green implements Color{

    @Override
    public String show() {
        return "green";
    }
}

public class Red implements Color{

    @Override
    public String show() {
        return "red";
    }
}

public class Yellow implements Color{

    @Override
    public String show() {
        return "yellow";
    }
}

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

public class ColorConstants {

    public static final String RED = "red";

    public static final String YELLOW = "yellow";

    public static final String GREEN = "green";
}

public interface Shape {

    /**
     * 展现
     */
    String show();
}

public class Circle implements Shape{

    @Override
    public String show() {
        return "圆形";
    }
}

public class Rectangle implements Shape{

    @Override
    public String show() {
        return  "长方形";
    }
}

public class Square implements Shape{

    @Override
    public String show() {
        return "正方形";
    }
}

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

public class ShapeConstants {

    public static final String RECTANGLE = "rectangle";

    public static final String SQUARE = "square";

    public static final String CIRCLE = "circle";
}

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

public class FactoryConstants {

    public static final String SHAPE_FACTORY = "shapeFactory";

    public static final String COLOR_FACTORY = "colorFactory";
}

public class Draw {

    public void draw(String shapeParam, String colorParam) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryConstants.SHAPE_FACTORY);
        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryConstants.COLOR_FACTORY);

        Shape shape = shapeFactory.getShape(shapeParam);
        Color color = colorFactory.getColor(colorParam);

        System.out.println(String.format("is drawing,%s的%s", color.show(), shape.show()));
    }
}

public class Test {

    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.draw(ShapeConstants.CIRCLE, ColorConstants.GREEN);
        draw.draw(ShapeConstants.SQUARE, ColorConstants.RED);
        draw.draw(ShapeConstants.RECTANGLE, ColorConstants.YELLOW);
    }
}
```