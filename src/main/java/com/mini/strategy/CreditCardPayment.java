package com.mini.strategy;

public class CreditCardPayment implements PaymentStrategy{

    private String cardNumber;

    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(float amount) {
        System.out.println(amount+"using credit card");
    }
}
