package by.zhdanovich.pars.interpreter;

public class TerminalExpressionDecrement extends AbstractMathExpression {
	@Override
	 public void interpret(Context c) { 
		 c.pushValue(c.popValue()-1);
	 } 
}
