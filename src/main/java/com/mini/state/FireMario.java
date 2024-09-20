package com.mini.state;

public class FireMario extends AbstractState  {
    MarioStateMachine marioStateMachine;

    public FireMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void meetMonster() {
        marioStateMachine.setScore(marioStateMachine.getScore() - 300);
        marioStateMachine.setCurrentState(new SmallMario(marioStateMachine));
    }
}
