package by.zhdanovich.pars.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.zhdanovich.pars.action.Action;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;
import by.zhdanovich.pars.parser.ParserToParagraph;
import by.zhdanovich.pars.reader.Reading;


public class RunnerTask {
	private static Logger log = LogManager.getLogger(RunnerTask.class);
	public static final String DATA = "text/data.txt";
	public static void main(String arg[]) {	
		Reading reading = new Reading();
		String text = reading.readText(DATA).toString();		
		
		ParserToParagraph parseToParagraph = new ParserToParagraph();		
		CompositeTool wholeText = new CompositeTool(EntityType.TEXT);		
		parseToParagraph.parseRequest(wholeText, text);		
		log.info("Parsed text:\n" + wholeText.toString()); 
		
		Action action = new Action();
		Component component = action.sortSentanceByQuantity(wholeText);
		log.info("TASK 2:\n" + component.toString());
		
		CompositeTool secondClon= wholeText.clone();
		action.changeOfPlace(secondClon);
		log.info("TASK 3:\n" + secondClon.toString()); 
		
		
		CompositeTool firstClon= wholeText.clone();
		action.deleteLexeme(firstClon);	
		log.info("TASK 6:\n" + firstClon.toString());
		
		
		
		
   }
}

