/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

public class BuddySpaceImpl implements BuddySpace {

	public BuddySpaceImpl() {
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
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			type = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			name = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getSize() {
		return size;
	}

	@Override
	public void setSize(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			size = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
