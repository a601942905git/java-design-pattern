package com.design.pattern.command.example;

/**
 * com.design.pattern.command.example.AudioPlayer
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午7:16
 */
public class AudioPlayer {

    public void play() {
        System.out.println("播放");
    }

    public void rewind() {
        System.out.println("倒带");
    }

    public void stop() {
        System.out.println("停止");
    }
}
