/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

public interface ISpace {
	
	Boolean isActivated();
	void activate(Boolean value);
	
	EnumSpace getType();
	void setType(EnumSpace value);
	
	Integer getNewValue();
	void setNewValue(Integer value);
	
	Integer getCurrentValue();
	void setCurrentValue(Integer value);
	
	Integer getRestValue();
	void setRestValue(Integer value);
}
