package com.design.pattern.command;

/**
 * com.design.pattern.command.Client
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:04
 */
public class Client {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command command = new ConcreteCommand(receiver);

        Invoker invoker = new Invoker(command);

        invoker.execute();
    }
}
