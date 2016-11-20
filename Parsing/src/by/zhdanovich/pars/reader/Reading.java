package by.zhdanovich.pars.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reading {
	private static Logger log = LogManager.getLogger(Reading.class);
    
	public StringBuilder readText(String s) {
		Scanner scanner = null;
		StringBuilder text = new StringBuilder();
		String b;		
		try {
			scanner = new Scanner(new FileReader(s));
			while (scanner.hasNext()) {
				b = scanner.nextLine();
				text.append(b);
			}
		} catch (FileNotFoundException e) {
			log.fatal("File was not found", e);
			throw new RuntimeException();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return text;
	}
}