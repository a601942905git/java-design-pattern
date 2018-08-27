package com.design.pattern.strategy;

/**
 * com.design.pattern.strategy.Context
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午11:11
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int num1, int num2) {
        if (null == strategy) {
            return 0;
        }
        return this.strategy.calculate(num1, num2);
    }
}
