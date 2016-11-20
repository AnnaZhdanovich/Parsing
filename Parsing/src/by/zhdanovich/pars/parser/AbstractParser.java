package by.zhdanovich.pars.parser;


import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;


public abstract class AbstractParser {	

public abstract Component parseRequest(CompositeTool tool, String text); 

}
