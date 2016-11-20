package by.zhdanovich.pars.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import by.zhdanovich.pars.translator.TranslatorToPolskaForm;

public class TranslatorToPolskaFormTest {
	public final static String EXPRESSION = "3+4*(5-4)+10";
	public static TranslatorToPolskaForm translator = new TranslatorToPolskaForm(); ;
	
	@Test
	public void transliteTest(){
		List<String> expected = new ArrayList<String>();
		expected.add("3");
		expected.add("4");
		expected.add("5");
		expected.add("4");
		expected.add("-");
		expected.add("*");
		expected.add("+");
		expected.add("10");
		expected.add("+");	
		List<String> actual = translator.translite(EXPRESSION);		
		Assert.assertEquals(expected, actual);
	}
}
