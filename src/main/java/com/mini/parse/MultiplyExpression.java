package com.mini.parse;

public class MultiplyExpression implements Expression {
    private Expression left;
    private Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public long interpret() {
        return left.interpret() * right.interpret();
    }
}
