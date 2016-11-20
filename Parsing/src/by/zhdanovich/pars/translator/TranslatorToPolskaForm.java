package by.zhdanovich.pars.translator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslatorToPolskaForm {
	public static final String REG_SYMBOL_IN_MATH_EXPRESSION = "[+|-]{2}|[0-9]{1,}|[\\p{Punct}]{1}";
	public static final String REG_NUMERAL = "[0-9]{1,}";
	public static final String REG_OPEN = "[(]";
	public static final String REG_CLOTHE = "[)]";
	public final static String PLUS = "+";
	public final static String MINUS = "-";
	public final static String MULTIPLY = "*";
	public final static String DIVIDE = "/";
	public final static String DECREMENT = "--";
	public final static String INCREMENT = "++";

	public List<String> translite(String expression) {
		CheckExpressionOnIncrement controller = new CheckExpressionOnIncrement();
		expression = controller.check(expression);
		List<String> list = new ArrayList<String>();
		Deque<String> deque = new LinkedList<String>();
		Pattern patternMath = Pattern.compile(REG_SYMBOL_IN_MATH_EXPRESSION);
		Matcher matcher = patternMath.matcher(expression);

		while (matcher.find()) {
			String symbol = matcher.group();

			if (Pattern.matches(REG_NUMERAL, symbol)) {
				list.add(symbol);

			} else {

				if (Pattern.matches(REG_OPEN, symbol)) {
					deque.addLast(symbol);

				} else {

					if (Pattern.matches(REG_CLOTHE, symbol)) {

						while (!Pattern.matches(REG_OPEN, deque.getLast())) {
							list.add(deque.getLast());
							deque.removeLast();
						}
						deque.removeLast();

					} else {						
							while ((!deque.isEmpty()) && (!Pattern.matches(REG_OPEN, deque.getLast()))
									&& (takeMarkOfOperator(symbol) <= takeMarkOfOperator(deque.getLast()))) {
								list.add(deque.getLast());
								deque.removeLast();
							}
						deque.addLast(symbol);
					}
				}
			}
		}
		while (!deque.isEmpty()) {
			list.add(deque.getLast());
			deque.removeLast();
		}
		return list;
	}

	private int takeMarkOfOperator(String operator) {
		int mark = 0;
		switch (operator) {
		case INCREMENT:
		case DECREMENT:
			mark = 6;
			break;
		case MULTIPLY:			
		case DIVIDE:
			mark = 4;
			break;
		case PLUS:			
		case MINUS:
			mark = 2;
			break;
		default:			
			throw new IllegalArgumentException("Wrong data");
		}
		return mark;
	}

}
