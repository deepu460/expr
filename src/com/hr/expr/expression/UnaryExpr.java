package com.hr.expr.expression;

public class UnaryExpr extends Expr {
	int rator;
	Expr rand;

	UnaryExpr(int rator, Expr rand) {
		this.rator = rator;
		this.rand = rand;
	}

	public double value() {
		double arg = rand.value();
		switch (rator) {
			case ABS:
				return Math.abs(arg);
			case ACOS:
				return Math.acos(arg);
			case ASIN:
				return Math.asin(arg);
			case ATAN:
				return Math.atan(arg);
			case CEIL:
				return Math.ceil(arg);
			case COS:
				return Math.cos(arg);
			case EXP:
				return Math.exp(arg);
			case FLOOR:
				return Math.floor(arg);
			case LOG:
				return Math.log(arg);
			case NEG:
				return -arg;
			case ROUND:
				return Math.rint(arg);
			case SIN:
				return Math.sin(arg);
			case SQRT:
				return Math.sqrt(arg);
			case TAN:
				return Math.tan(arg);
			default:
				throw new RuntimeException("BUG: bad rator");
		}
	}
}