package com.design.pattern.strategy;

/**
 * com.design.pattern.strategy.MultiStrategy
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午11:10
 */
public class MultiStrategy implements Strategy{

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
