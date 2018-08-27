package com.design.pattern.chain;

/**
 * com.design.pattern.chain.InfoLogger
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午4:31
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(Integer logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void write() {
        System.out.println("print info level log message");
    }
}
