package com.design.pattern.template;

/**
 * com.design.pattern.template.FootBallGame
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午2:54
 */
public class FootBallGame extends Game{

    @Override
    protected void initialize() {
        System.out.println("集齐22个人，每11个人为一队。双方守门员，踢球人员准备就绪，开始足球比赛。");
    }

    @Override
    protected void startPlay() {
        System.out.println("球员用脚进行踢球，踢来踢去。");
    }

    @Override
    protected void endPlay() {
        System.out.println("双方踢到90分钟，足球比赛结束。");
    }
}
