package com.design.pattern.chain;

/**
 * com.design.pattern.chain.DebugLogger
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午4:29
 */
public class DebugLogger extends AbstractLogger{

    public DebugLogger(Integer logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void write() {
        System.out.println("print debug level log message");
    }
}
