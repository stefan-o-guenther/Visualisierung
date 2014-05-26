/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class ProcessNodeImpl implements ProcessNode {

	public ProcessNodeImpl(String s, Integer value, BuddyNode p) {
		try {
			if ((s == null) || (value == null) || (p == null)) {
				throw new NullPointerException();
			}
			if (value < 0) {
				throw new IllegalArgumentException();
			}
			space = value;
			name = s;
			parent = p;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private BuddyNode parent = null;
	private Integer space = null;
	private String name = "";
	
	@Override
	public EnumNode getType() {
		return EnumNode.SPACE;
	}

	@Override
	public BuddyNode getParent() {
		return parent;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getValue() {
		return space;
	}

	@Override
	public void print() {
		System.out.println("SpaceNode: "+ name + " " + space);
	}

	@Override
	public List<BuddySpace> getNodeList(Integer limit) {
		try {
			if (limit == null) {
				throw new NullPointerException();
			}
			if (limit < 0) {
				throw new IllegalArgumentException();
			}
			List<BuddySpace> list = new ArrayList<BuddySpace>();
			BuddySpace ps = new BuddySpaceImpl();
			ps.setName(name);
			ps.setSize(space);
			ps.setType(getType());
			list.add(ps);
			return list;
		} catch (Exception ex) {
			throw ex;
		}		
	}
}
