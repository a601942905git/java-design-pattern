package com.design.pattern.command.example;

/**
 * com.design.pattern.command.example.RewindCommand
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:19
 */
public class RewindCommand implements Command {

    private AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.rewind();
    }
}
