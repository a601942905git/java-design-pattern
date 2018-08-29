package com.design.pattern.adapter;

/**
 * com.design.pattern.adapter.VlcPlayer
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午3:39
 */
public class VlcPlayer implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println(String.format("正在播放类型为：Vlc,名称为：%s的音频", fileName));
    }

    @Override
    public void playMp4(String fileName) {

    }
}
