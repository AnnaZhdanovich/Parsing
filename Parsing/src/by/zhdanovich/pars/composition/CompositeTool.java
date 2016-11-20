package by.zhdanovich.pars.composition;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class CompositeTool implements Component {
	private static Logger log = LogManager.getLogger(CompositeTool.class);
	private EntityType type;
	private ArrayList<Component> list;

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Component component : list){
			if(component.getType()==EntityType.LEXEMA){
			s.append(component.toString()+" ");
			}else {
				if(component.getType()==EntityType.PARAGRAPH){
				s.append(component.toString()+"\n");
				}else{
					s.append(component.toString());
				}
			}
		}
		return  s.toString();
		
	}

	public CompositeTool(EntityType type) {
		this.type = type;
		list = new ArrayList<Component>();
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}
	
	public ArrayList<Component> getList() {
		return list;
	}

	public void add(Component element) {
		list.add(element);
	}

	public void remove(Component element) {
		list.remove(list);
	}
	
	 
	public CompositeTool clone() {		  
		  CompositeTool copy = null;      
		  try {             
			  copy = (CompositeTool)super.clone();
			  ArrayList<Component> copylist =new ArrayList<Component>();
			  for(Component l: list){
				  copylist.add((Component)l.clone());  
			  }
			  copy.list=copylist;			  
			  copy.type=type;
			  } catch (CloneNotSupportedException e) {     
				  log.error("Wrong data", e);  
				  }                   
		  return copy;        
	  }
}
