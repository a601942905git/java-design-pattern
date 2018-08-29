package com.design.pattern.adapter;

import java.util.Objects;

/**
 * com.design.pattern.adapter.AudioMedia
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午3:35
 */
public class AudioMediaPlayer implements MediaPlayer {

    @Override
    public void play(String type, String fileName) {
        if (Objects.equals(type, MediaConstants.MP3)) {
            System.out.println(String.format("正在播放类型为：%s,名称为：%s的音频", type, fileName));
        } else if (Objects.equals(type, MediaConstants.MP4)
                || Objects.equals(type, MediaConstants.VLC)) {
            MediaAdapter mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type, fileName);
        } else {
            System.out.println("not found media");
        }
    }
}
