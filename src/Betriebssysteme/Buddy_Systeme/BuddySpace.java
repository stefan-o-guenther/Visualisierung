/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

public interface BuddySpace {

	public EnumNode getType();
	public void setType(EnumNode value);
	
	public String getName();
	public void setName(String value);
	
	public Integer getSize();
	public void setSize(Integer value);
}
