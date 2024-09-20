package com.mini.state;

public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtainMushRoom();

        marioStateMachine.obtaincape();
        marioStateMachine.obtainFire();
        marioStateMachine.meetMonster();
        System.out.printf("mario最终的分数："+marioStateMachine.getScore());
    }
}
