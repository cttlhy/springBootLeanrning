package com.mini.strategy;

public class ShopingCart {
    private PaymentStrategy strategy;

    public ShopingCart(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy paymentStrategy){
        strategy = paymentStrategy;
    }

    public void checkout(int amount){
        strategy.pay(amount);
    }

}
