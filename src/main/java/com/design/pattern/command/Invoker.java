package com.design.pattern.command;

/**
 * com.design.pattern.command.Invoker
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:04
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
