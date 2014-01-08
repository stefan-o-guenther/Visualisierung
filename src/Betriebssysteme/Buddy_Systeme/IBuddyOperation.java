package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface IBuddyOperation {
	String getMessage();
	void setMessage(String value);
	
	List<IProcessSpace> getBuddyList();
	void setBuddyList(List<IProcessSpace> value);
}
