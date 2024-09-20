package com.mini.state;

public class MarioStateMachine {

    private int score;
    private IState currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState =  new SmallMario(this);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }


    public IState getCurrentState() {
        return currentState;
    }

    public void obtainMushRoom() {
        System.out.println("获取mushroom:");
        currentState.obtainMushRoom();
    }

    public void obtaincape() {//TODO
        System.out.println("获取cape:");
        currentState.obtaincape();
    }

    //FIRE
    public void obtainFire() {//TODO
        System.out.println("获取fire:");
        currentState.obtainFire();
    }

    public void meetMonster() {//TODO
        System.out.println("遇到怪物:");
        currentState.meetMonster();
    }

    public int getScore() {
        return score;
    }



}
