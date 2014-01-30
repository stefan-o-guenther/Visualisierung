/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

public class BuddySpace implements IBuddySpace {

	public BuddySpace() {
		type = null;
		name = "";
		size = 0;
	}
	
	private EnumNode type;
	private String name;
	private Integer size;
	
	@Override
	public EnumNode getType() {
		return type;
	}

	@Override
	public void setType(EnumNode value) {
		if (value != null) {
			type = value;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		if (value != null) {
			name = value;
		}
	}

	@Override
	public Integer getSize() {
		return size;
	}

	@Override
	public void setSize(Integer value) {
		if ((value != null) && (value >= 0)) {
			size = value;
		}
	}
}
