package com.mini.state;

public class VendingMachine {
    private IState hasCoin;
    private IState noCoin;
    private IState sold;
    private IState soldOut;

    private IState currentState;
    private int count;

    public VendingMachine(int count) {
        this.hasCoin = new HasCoinState();
        this.noCoin = new NocoinState();
        this.sold = new SoldOutState();
        this.soldOut = new SoldOutState();
        this.count = count;

        if (count>0){
            this.currentState = noCoin;
        }else {
            this.currentState = soldOut;
        }
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public IState getHasCoin() {
        return hasCoin;
    }

    public IState getNoCoin() {
        return noCoin;
    }

    public IState getSold() {
        return sold;
    }

    public IState getSoldOut() {
        return soldOut;
    }

    public void insertCoin(){
        currentState.insertCoin();
    }

    public void ejectCoin(){
        currentState.ejectCoin();
    }

    public void pressButton(){
        currentState.pressButton();
        currentState.dispense();
    }

    public void releaseProduct(){
        if (count>0){
            count--;
            System.out.printf("商品发放ing");
        }
    }

    public int getCount() {
        return count;
    }

    public void refill(int count){
        this.count+=count;
        System.out.println("已装填 " + count + " 个商品。");
        currentState = noCoin;
    }
}
