package com.design.pattern.command.example;

/**
 * com.design.pattern.command.example.Keypad
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:21
 */
public class Keypad {

    private Command playCommand;

    private Command rewindCommand;

    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    public void play() {
        this.playCommand.execute();
    }

    public void rewind() {
        this.rewindCommand.execute();
    }

    public void stop() {
        this.stopCommand.execute();
    }
}
