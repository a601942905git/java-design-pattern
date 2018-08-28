package com.design.pattern.template;

/**
 * com.design.pattern.template.Game
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午2:53
 */
public abstract class Game {

    protected abstract void initialize();

    protected abstract void startPlay();

    protected abstract void endPlay();

    protected final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
