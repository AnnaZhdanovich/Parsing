package by.zhdanovich.pars.translator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpressionOnIncrement {
	public final static String REG_FOR_NUMB_AND_INCREM = "(([\\+\\-]{2}[0-9]{1,})|([0-9]{1,}[\\+\\-]{2})|([\\+\\-\\*\\/]?[0-9]{1,}[\\+\\-\\*\\/]?)|([\\(\\)]?))";
	public final static String REG_FOR_NUMBER = "[0-9]{1,}";
	public final static String REG_FOR_CHECKING_ON_INCREM = "([0-9]{1,}[+]{2})|([0-9]{1,}[-]{2})";

	public String check(String mathExpression) {
		StringBuilder ss = new StringBuilder();
		Pattern pattertParagraph = Pattern.compile(REG_FOR_NUMB_AND_INCREM);
		Matcher matcher = pattertParagraph.matcher(mathExpression);
		while (matcher.find()) {
			String s = matcher.group();
			ss.append(this.deleteOfIncrement(s));
		}
		return ss.toString();
	}

	private String deleteOfIncrement(String s) {
		StringBuilder str = new StringBuilder();
		if (Pattern.matches(REG_FOR_CHECKING_ON_INCREM, s)) {
			Pattern pattertIncrement = Pattern.compile(REG_FOR_NUMBER);
			Matcher matcherIncrement = pattertIncrement.matcher(s);
			while (matcherIncrement.find()) {
				String d = matcherIncrement.group();
				str.append(d);
			}
		} else {
			str.append(s);
		}
		return str.toString();
	}
}
