package com.mini.strategy;

public class PayPalPayment implements PaymentStrategy{
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(float amount) {
        System.out.println(amount+" using payPal");
    }
}
