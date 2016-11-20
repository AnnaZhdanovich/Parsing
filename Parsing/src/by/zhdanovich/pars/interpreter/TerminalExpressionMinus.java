package by.zhdanovich.pars.interpreter;

public class TerminalExpressionMinus extends AbstractMathExpression {
	 @Override 
	 public void interpret(Context c) { 
		if(!(c.getContextValues().size()>2)){
			c.getContextValues().add(0.0);
		}	
		 Double n1 = c.popValue();
		 Double n2 = c.popValue();
		 c.pushValue(n2 - n1);
		 } 
}
