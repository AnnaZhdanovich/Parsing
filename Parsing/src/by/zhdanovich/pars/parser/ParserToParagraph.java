package by.zhdanovich.pars.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;

public class ParserToParagraph extends AbstractParser {
public static final String REGEX_PARAGRAPH = "[\\p{Blank}]{1,}[[^\\t].]*[.!?]";

	@Override
	public Component parseRequest(CompositeTool wholeText, String text) {
		ParserToSentance pts = new ParserToSentance();
		Pattern pattertParagraph = Pattern.compile(REGEX_PARAGRAPH);
		String paragraph = "";
		Matcher matcher = pattertParagraph.matcher(text);
		while (matcher.find()) {
			paragraph = matcher.group();
			CompositeTool paragraphList = new CompositeTool(EntityType.PARAGRAPH);
			wholeText.add(pts.parseRequest(paragraphList, paragraph));
		}
		return wholeText;
	}
}
