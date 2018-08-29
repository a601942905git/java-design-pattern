package com.design.pattern.adapter;

/**
 * com.design.pattern.adapter.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午3:56
 */
public class Test {

    public static void main(String[] args) {
        MediaPlayer media = new AudioMediaPlayer();
        media.play("mp3", "beyond the horizon.mp3");
        media.play("mp4", "alone.mp4");
        media.play("vlc", "far far away.vlc");
        media.play("avi", "mind me.avi");
    }
}
