/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class BuddyOperationImpl implements BuddyOperation {

	public BuddyOperationImpl() {
		message = "";
		list = new ArrayList<BuddySpace>();
	}
	
	private String message;
	private List<BuddySpace> list;
	
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
	public List<BuddySpace> getBuddyList() {
		return list;
	}

	@Override
	public void setBuddyList(List<BuddySpace> value) {
		if (value != null) {
			list = value;
		}
	}
}
