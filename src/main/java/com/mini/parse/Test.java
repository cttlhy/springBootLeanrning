package com.mini.parse;

public class Test
{
    public static void main(String[] args)
    {
        // 1+2
        Expression expression = new AddExpression(new NumberExpression(1), new NumberExpression(2));
        System.out.println(expression.interpret());

        String str = "1+2";
        expression = new AddExpression(new NumberExpression(1), new NumberExpression(2));
        System.out.println(expression.interpret());
    }
}
