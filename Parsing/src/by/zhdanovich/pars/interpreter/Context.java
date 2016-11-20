package by.zhdanovich.pars.interpreter;

import java.util.ArrayDeque;

public class Context {
	
	private ArrayDeque<Double> contextValues = new ArrayDeque<>();
	
	public ArrayDeque<Double> getContextValues() {
		return contextValues;
	}

	public void setContextValues(ArrayDeque<Double> contextValues) {
		this.contextValues = contextValues;
	}

	public Double popValue() {  
		return contextValues.pop(); 		
		} 
	
	
	public void pushValue(Double value) {
		this.contextValues.push(value);
		} 
}
