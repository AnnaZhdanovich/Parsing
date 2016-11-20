package by.zhdanovich.pars.interpreter;

public class TerminalExpressionMultiply extends AbstractMathExpression{
	@Override
	public void interpret(Context c) {
		
		c.pushValue(c.popValue() * c.popValue());
	}
}
