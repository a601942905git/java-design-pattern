package com.design.pattern.template;

/**
 * com.design.pattern.template.BaseketBallGame
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午3:00
 */
public class BasketBallGame extends Game{

    @Override
    protected void initialize() {
        System.out.println("集齐10个人，每5个人为一队。双方球员准备就绪，开始篮球比赛。");
    }

    @Override
    protected void startPlay() {
        System.out.println("球员用手控球，传来传去。");
    }

    @Override
    protected void endPlay() {
        System.out.println("踢完48分钟，篮球比赛结束。");
    }
}
