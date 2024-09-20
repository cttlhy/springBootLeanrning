package com.mini.state;

public class SuperMario implements IState {
    MarioStateMachine marioStateMachine;

    public SuperMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtaincape() {
        marioStateMachine.setScore(marioStateMachine.getScore()+200);
        marioStateMachine.setCurrentState(new CapeMario(marioStateMachine));
    }

    @Override
    public void obtainFire() {
        marioStateMachine.setScore(marioStateMachine.getScore()+300);
        marioStateMachine.setCurrentState(new FireMario(marioStateMachine));
    }

    @Override
    public void meetMonster() {
        marioStateMachine.setScore(marioStateMachine.getScore()-100);
        marioStateMachine.setCurrentState(new SmallMario(marioStateMachine));
    }
}
