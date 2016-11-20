package by.zhdanovich.pars.test;

import org.junit.Assert;
import org.junit.Test;

import by.zhdanovich.pars.translator.CheckExpressionOnIncrement;


public class CheckExpressionOnIncrementTest {
	public final static String EXPRESSION = "(++3)+4+(4++)";
	public static CheckExpressionOnIncrement controller = new CheckExpressionOnIncrement();
	
	@Test
	public void checkTest(){
		String expected = "(++3)+4+(4)";		
		String actual = controller.check(EXPRESSION);
		Assert.assertEquals(expected, actual); 		
	}
	
}
