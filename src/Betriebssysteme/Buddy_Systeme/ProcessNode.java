/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class ProcessNode implements IProcessNode {

	private IBuddyNode parent = null;
	private Integer space = null;
	private String name = "";
	
	public ProcessNode(String s, Integer value, IBuddyNode p) {
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
	
	@Override
	public EnumNode getType() {
		return EnumNode.SPACE;
	}

	@Override
	public IBuddyNode getParent() {
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
	public List<IBuddySpace> getNodeList(Integer limit) {
		List<IBuddySpace> list = new ArrayList<IBuddySpace>();
		if (limit == null) {
			limit = 0;
		}
		IBuddySpace ps = new BuddySpace();
		ps.setName(name);
		ps.setSize(space);
		ps.setType(getType());
		list.add(ps);
		return list;
	}

}
