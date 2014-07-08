package com.hr.expr.example;

import com.hr.expr.expression.Expr;
import com.hr.expr.parser.Parser;
import com.hr.expr.parser.SyntaxException;
import com.hr.expr.parser.Variable;

/**
 * A simple example of parsing and evaluating an expression. This puts the
 * expression evaluator through its paces. <br>
 * <br>
 * Sample usage: <br>
 * <br>
 * $ java expr.Example '3.14159 * x^2' 0 4 1 <br>
 * 0 <br>
 * 3.14159 <br>
 * 12.5664 <br>
 * 28.2743 <br>
 * 50.2654 <br>
 * <br>
 * $ java expr.Example 'sin (pi/4 * x)' 0 4 1 <br>
 * 0 <br>
 * 0.707107 <br>
 * 1 <br>
 * 0.707107 <br>
 * 1.22461e-16 <br>
 * <br>
 * $ java expr.Example 'sin (pi/4 x)' 0 4 1 <br>
 * I don't understand your formula "sin (pi/4 x)". <br>
 * <br>
 * I got as far as "sin (pi/4" and then saw "x". <br>
 * I expected ")" at that point, instead. <br>
 * An example of a formula I can parse is "sin (pi/4 + x)".
 */
public class Example {

	public static void main(String[] args) {
		Expr expr;

		try {
			expr = Parser.parse(args[0]);
		} catch (SyntaxException e) {
			e.printExplanation();
			return;
		}

		double low = Double.valueOf(args[1]).doubleValue();
		double high = Double.valueOf(args[2]).doubleValue();
		double step = Double.valueOf(args[3]).doubleValue();

		Variable x = Variable.make("x");
		for (double xval = low; xval <= high; xval += step) {
			x.setValue(xval);
			System.out.println(expr.value());
		}
	}

}