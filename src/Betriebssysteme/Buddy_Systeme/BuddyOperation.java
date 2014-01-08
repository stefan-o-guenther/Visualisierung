package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class BuddyOperation implements IBuddyOperation {

	private String message = "";
	private List<IProcessSpace> list = new ArrayList<IProcessSpace>();
	
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
	public List<IProcessSpace> getBuddyList() {
		return list;
	}

	@Override
	public void setBuddyList(List<IProcessSpace> value) {
		if (value != null) {
			list = value;
		}
	}
}
