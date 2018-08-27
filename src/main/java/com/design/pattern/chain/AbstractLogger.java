package com.design.pattern.chain;

/**
 * com.design.pattern.chain.AbstractLogger
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午4:20
 */
public abstract class AbstractLogger {

    protected Integer logLevel = 0;

    protected AbstractLogger next;

    public void setNext(AbstractLogger abstractLogger) {
        this.next = abstractLogger;

    }

    public void logMessage(Integer logLevel) {
        if (this.logLevel <= logLevel) {
            write();
        }

        if (null != next) {
            next.logMessage(logLevel);
        }
    }

    public abstract void write();
}
