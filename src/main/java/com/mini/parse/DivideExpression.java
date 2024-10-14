package com.mini.parse;

public class DivideExpression implements Expression {

    private Expression left;
    private Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public long interpret() {
        return left.interpret() / right.interpret();
    }
}
