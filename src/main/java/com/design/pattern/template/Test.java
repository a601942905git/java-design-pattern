package com.design.pattern.template;

/**
 * com.design.pattern.template.Test
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午3:03
 */
public class Test {

    public static void main(String[] args) {
        Game footBallGame = new FootBallGame();
        footBallGame.play();
        System.out.println("\n");
        Game basketBallGame = new BasketBallGame();
        basketBallGame.play();
    }
}
