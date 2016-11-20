package by.zhdanovich.pars.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;

public class ParserToSentance extends AbstractParser {
	public static final String REGEX_SENTANCE = "[\\p{Blank}]{1,}]*[A-Z][^?!.]*[.?!]";	

	@Override
	public Component parseRequest(CompositeTool paragraphList, String paragraph) {
		ParserToLexeme ptl = new ParserToLexeme();
		Pattern patternSentance = Pattern.compile(REGEX_SENTANCE);
		String sentance = "";
		Matcher matcher = patternSentance.matcher(paragraph);
		while (matcher.find()) {
			sentance = matcher.group();
			CompositeTool sentanceList = new CompositeTool(EntityType.SENTANCE);
			paragraphList.add(ptl.parseRequest(sentanceList, sentance));
		}
		return paragraphList;
	}

}
