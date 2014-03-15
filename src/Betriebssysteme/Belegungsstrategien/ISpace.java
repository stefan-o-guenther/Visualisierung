/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

public interface ISpace {
	
	public Boolean isActivated();
	public void activate(Boolean value);
	
	public EnumSpace getType();
	public void setType(EnumSpace value);
	
	public Integer getNewValue();
	public void setNewValue(Integer value);
	
	public Integer getCurrentValue();
	public void setCurrentValue(Integer value);
	
	public Integer getRestValue();
	public void setRestValue(Integer value);
}
