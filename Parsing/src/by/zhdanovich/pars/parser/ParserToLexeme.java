package by.zhdanovich.pars.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;

public class ParserToLexeme extends AbstractParser {
	public static final String REGEX_LEXEME = "[\\p{Punct}\\w]+";

	public Component parseRequest(CompositeTool sentanceList, String sentance) {
		ParserToWord ptw = new ParserToWord();
		Pattern patternLexeme = Pattern.compile(REGEX_LEXEME);
		String lexeme = "";
		Matcher matcher = patternLexeme.matcher(sentance);
		while (matcher.find()) {
			lexeme = matcher.group();

			CompositeTool lexemeList = new CompositeTool(EntityType.LEXEMA);
			sentanceList.add(ptw.parseRequest(lexemeList, lexeme));
		}
		return sentanceList;
	}
}
