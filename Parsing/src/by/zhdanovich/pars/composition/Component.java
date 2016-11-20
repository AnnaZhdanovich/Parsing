package by.zhdanovich.pars.composition;


import java.util.List;

public interface Component extends Cloneable{
	public EntityType getType();
	public List<Component> getList() ;
	public Component clone();
}
