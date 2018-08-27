package com.design.pattern.chain;

/**
 * com.design.pattern.chain.ErrorLogger
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午4:33
 */
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(Integer logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void write() {
        System.out.println("print error level log message");
    }
}
