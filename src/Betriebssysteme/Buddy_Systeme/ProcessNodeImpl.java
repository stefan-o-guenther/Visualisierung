/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class ProcessNodeImpl implements ProcessNode {

	public ProcessNodeImpl(String s, Integer value, BuddyNode p) {
		if ((value == null) || (value < 0)) {
			value = 0;
		}		
		if (s == null) {
			s = "";
		}
		space = value;
		name = s;
		parent = p;
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
		List<BuddySpace> list = new ArrayList<BuddySpace>();
		if (limit == null) {
			limit = 0;
		}
		BuddySpace ps = new BuddySpaceImpl();
		ps.setName(name);
		ps.setSize(space);
		ps.setType(getType());
		list.add(ps);
		return list;
	}

}
