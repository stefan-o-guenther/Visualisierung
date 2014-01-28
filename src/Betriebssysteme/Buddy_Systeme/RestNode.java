/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

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
	public List<IBuddySpace> getNodeList(Integer limit) {
		List<IBuddySpace> list = new ArrayList<IBuddySpace>();
		if (limit == null) {
			limit = 0;
		}
		IBuddySpace ps = new BuddySpace();
		ps.setName("");
		ps.setSize(space);
		ps.setType(getType());
		list.add(ps);
		return list;
	}

}
