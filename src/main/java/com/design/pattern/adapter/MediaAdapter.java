package com.design.pattern.adapter;

import java.util.Objects;

/**
 * com.design.pattern.adapter.MediaAdapter
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午3:40
 */
public class MediaAdapter implements MediaPlayer {

    private AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String type) {
        if (Objects.equals(type, MediaConstants.MP4)) {
            advanceMediaPlayer = new Mp4Player();
        } else if (Objects.equals(type, MediaConstants.VLC)) {
            advanceMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String type, String fileName) {
        if (Objects.equals(type, MediaConstants.MP4)) {
            advanceMediaPlayer.playMp4(fileName);
        } else if (Objects.equals(type, MediaConstants.VLC)) {
            advanceMediaPlayer.playVlc(fileName);
        }
    }
}
