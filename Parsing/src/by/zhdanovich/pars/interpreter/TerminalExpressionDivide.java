package by.zhdanovich.pars.interpreter;

public class TerminalExpressionDivide extends AbstractMathExpression {
	 @Override 
	 public void interpret(Context c) { 
		 Double n1 = c.popValue();
		 Double n2 = c.popValue();
		 c.pushValue(n2 / n1);
	 }
}
