package com.design.pattern.command.example;

/**
 * com.design.pattern.command.example.PlayCommand
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:16
 */
public class PlayCommand implements Command {

    private AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        this.audioPlayer.play();
    }
}
