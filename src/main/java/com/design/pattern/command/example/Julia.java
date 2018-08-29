package com.design.pattern.command.example;

/**
 * com.design.pattern.command.example.Julia
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:23
 */
public class Julia {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);

        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);

        keypad.play();
        keypad.rewind();
        keypad.stop();
    }
}
