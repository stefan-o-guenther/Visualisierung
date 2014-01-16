package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface IBuddyOperation {
	String getMessage();
	void setMessage(String value);
	
	List<IBuddySpace> getBuddyList();
	void setBuddyList(List<IBuddySpace> value);
}
