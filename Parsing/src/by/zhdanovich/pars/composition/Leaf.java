package by.zhdanovich.pars.composition;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Leaf implements Component {
	private static Logger log = LogManager.getLogger(Leaf.class);
	private EntityType type;
	private Character c;

	public Leaf(EntityType type, Character c) {
		this.type = type;
		this.c = c;
		
	}

	@Override
	public String toString() {
		return  c.toString();
	}

	public Character getC() {
		return c;
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}
	
	public Leaf clone() {
		Leaf copy = null;      
		  try {             
			  copy = (Leaf)super.clone();
			  copy.c=c;
			  copy.type=type;
			  } catch (CloneNotSupportedException e) {     
				  log.error("Wrong data", e);   
			  }                   
		  return copy;  
	  }

	@Override
	public ArrayList<Component> getList() {
	return null;
	}
	
}
