/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface IBuddyOperation {
	String getMessage();
	void setMessage(String value);
	
	List<IBuddySpace> getBuddyList();
	void setBuddyList(List<IBuddySpace> value);
}
