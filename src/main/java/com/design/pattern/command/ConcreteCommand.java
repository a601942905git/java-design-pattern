package com.design.pattern.command;

/**
 * com.design.pattern.command.ConcreteCommand
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:04
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.execute();
    }
}
