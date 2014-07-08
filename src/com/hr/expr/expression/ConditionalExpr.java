package com.hr.expr.expression;


public class ConditionalExpr extends Expr {

	Expr test, consequent, alternative;

	ConditionalExpr(Expr test, Expr consequent, Expr alternative) {
		this.test = test;
		this.consequent = consequent;
		this.alternative = alternative;
	}

	public double value() {
		return test.value() != 0 ? consequent.value() : alternative.value();
	}

}