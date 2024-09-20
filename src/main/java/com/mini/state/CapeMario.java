package com.mini.state;

public class CapeMario extends AbstractState {
    MarioStateMachine marioStateMachine;

    public CapeMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void meetMonster() {
        marioStateMachine.setScore(marioStateMachine.getScore()-400);
        marioStateMachine.setCurrentState(new SmallMario(marioStateMachine));
    }
}
