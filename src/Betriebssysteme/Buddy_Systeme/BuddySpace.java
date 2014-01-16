package Betriebssysteme.Buddy_Systeme;

public class BuddySpace implements IBuddySpace {

	private EnumNode type = null;
	private String name = "";
	private Integer size = 0;
	
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
