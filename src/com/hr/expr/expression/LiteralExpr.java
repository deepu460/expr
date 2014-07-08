package com.hr.expr.expression;

public class LiteralExpr extends Expr {

	double v;

	LiteralExpr(double v) {
		this.v = v;
	}

	public double value() {
		return v;
	}

}