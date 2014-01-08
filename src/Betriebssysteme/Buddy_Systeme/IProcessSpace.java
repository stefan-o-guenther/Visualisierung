package Betriebssysteme.Buddy_Systeme;

public interface IProcessSpace {

	EnumNode getType();
	void setType(EnumNode value);
	
	String getName();
	void setName(String value);
	
	Integer getSize();
	void setSize(Integer value);
}
