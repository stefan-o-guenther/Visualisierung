package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class RestNode implements IRestNode {

	private Integer space = 0;
	private IBuddyNode parent = null;
	
	public RestNode(Integer value, IBuddyNode p) {
		if ((value == null) || (value < 0)) {
			value = 0;
		}
		parent = p;
		space = value;
	}
	
	@Override
	public EnumNode getType() {
		return EnumNode.REST;
	}

	@Override
	public Integer getValue() {
		return space;
	}

	@Override
	public IBuddyNode getParent() {
		return parent;
	}

	@Override
	public void print() {
		System.out.println("RestNode: "+ space);
	}

	@Override
	public List<IProcessSpace> getNodeList(List<IProcessSpace> list, Integer limit) {
		if (list == null) {
			list = new ArrayList<IProcessSpace>();
		}
		if (limit == null) {
			limit = 0;
		}
		IProcessSpace ps = new ProcessSpace();
		ps.setName("");
		ps.setSize(space);
		ps.setType(getType());
		list.add(ps);
		return list;
	}

}
