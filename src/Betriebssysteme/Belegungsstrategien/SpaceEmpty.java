package Betriebssysteme.Belegungsstrategien;

public interface SpaceEmpty extends Space {

	public Boolean isActivated();
	public void activate(Boolean value);	
	
	public void setNewValue(Integer value);
	
	public Integer getNewValue();
	public Integer getRestValue();
	
	public Boolean isRestValue();
	public void showRestValue(Boolean value);
	
	public Boolean isNewValue();
	public void showNewValue(Boolean value);
}
