package com.design.pattern.strategy;

/**
 * com.design.pattern.strategy.Test
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午11:13
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println(context.calculate(1, 2));

        context = new Context(new SubtractStrategy());
        System.out.println(context.calculate(10, 5));

        context = new Context(new MultiStrategy());
        System.out.println(context.calculate(2, 4));

        context = new Context(new DivideStrategy());
        System.out.println(context.calculate(80, 5));
    }
}
