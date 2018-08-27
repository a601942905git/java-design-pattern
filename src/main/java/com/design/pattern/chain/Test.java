package com.design.pattern.chain;

/**
 * com.design.pattern.chain.Test
 *
 * @author lipeng
 * @dateTime 2018/8/27 下午4:34
 */
public class Test {

    public static void main(String[] args) {
        AbstractLogger debugLogger = new DebugLogger(1);
        AbstractLogger infoLogger = new InfoLogger(2);
        AbstractLogger errorLogger = new ErrorLogger(3);

        debugLogger.setNext(infoLogger);
        infoLogger.setNext(errorLogger);

        debugLogger.logMessage(1);
        System.out.println("===========");
        debugLogger.logMessage(2);
        System.out.println("===========");
        debugLogger.logMessage(3);
    }
}
