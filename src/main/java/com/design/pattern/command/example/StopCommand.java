package com.design.pattern.command.example;

/**
 * com.design.pattern.command.example.StopCommand
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:20
 */
public class StopCommand implements Command {

    private AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.stop();
    }
}
