/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface IBuddyOperation {
	public String getMessage();
	public void setMessage(String value);
	
	public List<IBuddySpace> getBuddyList();
	public void setBuddyList(List<IBuddySpace> value);
}
