package by.zhdanovich.pars.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;
import by.zhdanovich.pars.composition.Leaf;
import by.zhdanovich.pars.interpreter.Client;
import by.zhdanovich.pars.translator.TranslatorToPolskaForm;

public class ParserToWord extends AbstractParser {
	public static final String REGEX_WORD = "[-\\p{Lower}\\p{Upper}]+";
	public static final String REGEX_MATH_EXPRESSION = "[\\p{Punct}[0-9]]+";
	public static final String REGEX_WORD_AND_SIGN = "[[-\\p{Lower}\\p{Upper}]+|\\p{Punct}]";
	public static final String REGEX_SIGN = "\\p{Punct}";
	

	public Component parseRequest(CompositeTool lexemeList, String lexeme) {
         ParserToSumbol pts = new ParserToSumbol();
		if (Pattern.matches(REGEX_MATH_EXPRESSION, lexeme)) {
			CompositeTool mathExpression = new CompositeTool(EntityType.MATH_EXPRESSION);
			TranslatorToPolskaForm tpf = new TranslatorToPolskaForm();
			List<String> list = tpf.translite(lexeme);
			Client c = new Client(list);
			String i = c.calculate().toString();
			Component m = pts.parseRequest(mathExpression, i);
			lexemeList.add(m);
			return lexemeList;
		}

		if (Pattern.matches(REGEX_WORD, lexeme)) {
			CompositeTool word = new CompositeTool(EntityType.WORD);
			Component w = pts.parseRequest(word, lexeme);
			lexemeList.add(w);
		} else {
			Pattern patternLexeme = Pattern.compile(REGEX_WORD_AND_SIGN);
			String text = "";
			Matcher matcher = patternLexeme.matcher(lexeme);
			while (matcher.find()) {
				text = matcher.group();
				if (Pattern.matches(REGEX_SIGN, text)) {
					Leaf leaf = new Leaf(EntityType.SYMBOL, text.charAt(0));
					lexemeList.add(leaf);
				}else{
				CompositeTool word = new CompositeTool(EntityType.WORD);
				Component w = pts.parseRequest(word, text);
				lexemeList.add(w);
				}
			}
		}
		return lexemeList;
	}
}
