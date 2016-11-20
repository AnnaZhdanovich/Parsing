package by.zhdanovich.pars.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;
import by.zhdanovich.pars.composition.Leaf;

public class ParserToSumbol extends AbstractParser {
	
	public static final String REGEX_SYMBOL = ".{1}";

	

	public Component parseRequest(CompositeTool word, String text) {

		Pattern patternSentance = Pattern.compile(REGEX_SYMBOL);
		String symbol = "";
		Matcher matcher = patternSentance.matcher(text);
		while (matcher.find()) {
			symbol = matcher.group();
			Leaf leaf = new Leaf(EntityType.SYMBOL, symbol.charAt(0));
			word.add(leaf);
		}
		return word;
	}

}
