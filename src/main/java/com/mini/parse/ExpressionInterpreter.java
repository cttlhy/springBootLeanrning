package com.mini.parse;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter {

    Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] elements = expression.split(" ");

        for (int i = 0; i < elements.length /2; i++) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i = elements.length / 2; i < elements.length; i++) {
            String element = elements[i];
            boolean isValid =
                    element.equals("+") || element.equals("-")
                            || element.equals("*") || element.equals("/");
            if (!isValid) {
                throw new RuntimeException("Invalid expression");
            }

            Expression expression1 = numbers.pollFirst();
            Expression expression2 = numbers.pollFirst();

            Expression combined = null;
            if (element.equals("+")) {
                combined = new AddExpression(expression1,expression2);
            }else if (element.equals("-")) {
                combined = new SubtractExpression(expression1,expression2);
            }else if (element.equals("*")) {
                combined = new MultiplyExpression(expression1,expression2);
            }else if (element.equals("/")) {
                combined = new DivideExpression(expression1,expression2);
            }
            long result = combined.interpret();
            numbers.addFirst(new NumberExpression(result));
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Invalid expression");
        }
        return numbers.pop().interpret();
    }
}
