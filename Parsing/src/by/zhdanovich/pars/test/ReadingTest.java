package by.zhdanovich.pars.test;

import org.junit.Test;
import by.zhdanovich.pars.reader.Reading;

public class ReadingTest {	
	
@Test( expected = RuntimeException.class ) 
public void readTextTest() throws RuntimeException {
	Reading reader = new Reading();
	reader.readText("data/text.txt");
	}

}
