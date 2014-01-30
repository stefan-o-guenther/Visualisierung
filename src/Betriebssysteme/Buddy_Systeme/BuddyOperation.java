/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class BuddyOperation implements IBuddyOperation {

	public BuddyOperation() {
		message = "";
		list = new ArrayList<IBuddySpace>();
	}
	
	private String message;
	private List<IBuddySpace> list;
	
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String value) {
		if (value != null) {
			message = value;
		}
	}

	@Override
	public List<IBuddySpace> getBuddyList() {
		return list;
	}

	@Override
	public void setBuddyList(List<IBuddySpace> value) {
		if (value != null) {
			list = value;
		}
	}
}
