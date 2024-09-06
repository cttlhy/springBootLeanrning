package com.mini.strategy;

public class TestStrategy
{
    public static void main(String[] args) {
        PaymentStrategy strategy = new PayPalPayment("2222222@qq.com");

        ShopingCart shopingCart = new ShopingCart(strategy);
        shopingCart.checkout(110);

        shopingCart.setStrategy(new CreditCardPayment("111111","ctt"));
        shopingCart.checkout(1102);
    }
}
