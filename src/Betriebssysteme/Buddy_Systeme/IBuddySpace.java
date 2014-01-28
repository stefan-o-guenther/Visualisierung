/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

public interface IBuddySpace {

	EnumNode getType();
	void setType(EnumNode value);
	
	String getName();
	void setName(String value);
	
	Integer getSize();
	void setSize(Integer value);
}
