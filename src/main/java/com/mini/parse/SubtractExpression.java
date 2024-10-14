package com.mini.parse;

public class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public long interpret() {
        return left.interpret() - right.interpret();
    }
}
