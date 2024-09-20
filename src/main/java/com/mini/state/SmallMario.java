package com.mini.state;

public class SmallMario extends AbstractState {
    MarioStateMachine marioStateMachine;

    public SmallMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void obtainMushRoom() {
        marioStateMachine.setScore(marioStateMachine.getScore()+100);
        marioStateMachine.setCurrentState(new SuperMario(marioStateMachine));
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

}
