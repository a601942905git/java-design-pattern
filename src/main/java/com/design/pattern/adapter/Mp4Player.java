package com.design.pattern.adapter;

/**
 * com.design.pattern.adapter.Mp4Player
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午3:38
 */
public class Mp4Player implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(String.format("正在播放类型为：Mp4,名称为：%s的音频", fileName));
    }
}
