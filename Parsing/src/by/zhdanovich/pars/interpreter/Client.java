package by.zhdanovich.pars.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public final static String PLUS = "+";
	public final static String MINUS = "-";
	public final static String MULTIPLY = "*";
	public final static String DIVIDE = "/";
	public final static String DECREMENT = "--";
	public final static String INCREMENT = "++";

	private ArrayList<AbstractMathExpression> listExpression;

	public Client(List<String> expression) {
		listExpression = new ArrayList<>();
		parse(expression);
	}

	private void parse(List<String> expression) {
		for (String symbol : expression) {

			switch (symbol) {
			case PLUS:
				listExpression.add(new TerminalExpressionPlus());
				break;
			case MINUS:
				listExpression.add(new TerminalExpressionMinus());
				break;
			case MULTIPLY:
				listExpression.add(new TerminalExpressionMultiply());
				break;
			case DIVIDE:
				listExpression.add(new TerminalExpressionDivide());
				break;
			case INCREMENT:
				listExpression.add(new TerminalExpressionIncrement());
				break;
			case DECREMENT:
				listExpression.add(new TerminalExpressionDecrement());
				break;
			default:
				listExpression.add(new NonterminalExpressionNumber(Integer.parseInt(symbol)));
			}
		}
	}

	public Number calculate() {

		Context context = new Context();

		for (AbstractMathExpression terminal : listExpression) {

			terminal.interpret(context);

		}
		return context.popValue();
	}

}
