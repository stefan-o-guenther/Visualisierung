/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class BuddyNode implements IBuddyNode {

	public BuddyNode(Integer value, IBuddyNode p) {
		if ((value != null) && (value > 0)) {
			Integer x = BuddyHelper.getPotence(value);
			size = (int) Math.pow(2, x);
		} else {
			size = 0;
		}
		parent = p;
	}
	
	private Integer size = 0;
	private IBuddyNode left = null;
	private IBuddyNode right = null;
	private IBuddyNode parent = null;
	private IProcessNode space = null;
	private IRestNode rest = null;
	
	@Override
	public Integer getValue() {
		return size;
	}

	@Override
	public Boolean hasChildren() {
		return ((left != null) || (right != null));
	}

	@Override
	public IBuddyNode getLeftBuddyNode() {
		return left;
	}

	@Override
	public void setLeftBuddyNode(IBuddyNode value) {
		if (value != null) {
			left = value;
		}
	}

	@Override
	public IBuddyNode getRightBuddyNode() {
		return right;
	}

	@Override
	public void setRightBuddyNode(IBuddyNode value) {
		if (value != null) {
			right = value;
		}
	}
	
	@Override
	public IProcessNode getSpaceNode() {
		return space;
	}

	@Override
	public void setSpaceNode(IProcessNode value) {
		if (value != null) {
			space = value;
		}
	}

	@Override
	public IRestNode getRestNode() {
		return rest;
	}

	@Override
	public void setRestNode(IRestNode value) {
		if (value != null) {
			rest = value;
		}
	}

	@Override
	public EnumNode getType() {
		return EnumNode.BUDDY;
	}

	@Override
	public IBuddyNode getParent() {
		return parent;
	}

	@Override
	public IProcessNode insertSpace(String name, Integer value) {
		if ((name != null) && (value != null) && (value >= 0)) {
			if (value > size) {
				return null;
			} else {
				Integer ownPotence = BuddyHelper.getPotence(size);
				Integer valuePotence = BuddyHelper.getPotence(value);
				if (ownPotence < valuePotence) {
					return null;
				} else if (ownPotence.equals(valuePotence)) {
					if (isEmpty()) {
						space = new ProcessNode(name, value, this);
						rest = new RestNode(size-value, this);
						return space;
					} else {
						return null;
					}
				} else if ((ownPotence > valuePotence) && (ownPotence > 0)) {
					if (space != null) {
						return null;
					}
					if (left == null) {
						left = new BuddyNode((size/2), this);
					}
					if (right == null) {
						right = new BuddyNode((size/2), this);
					}				
					IProcessNode node = left.insertSpace(name, value);
					if (node == null) {
						node = right.insertSpace(name, value);					
					}
					return node;
				} else {
					return null;
				}
			}			
		} else {
			return null;
		}
	}

	@Override
	public Boolean isEmpty() {
		return ((left == null) && (right == null) && (space == null) && (rest == null));
	}

	@Override
	public void print() {
		System.out.println("BuddyNode: " + size);
		if (left != null) {
			left.print();
		}
		if (right != null) {
			right.print();
		}
		if (space != null) {
			space.print();
		}
		if (rest != null) {
			rest.print();
		}
	}

	@Override
	public Boolean clean() {
		if ((left != null) && (right != null)) {
			if (left.isEmpty() && right.isEmpty()) {
				left = null;
				right = null;
				return true;
			} else {
				Boolean result = left.clean();
				if (result == false) {
					result = right.clean();
				}
				return result;
			}
		} else {
			return false;
		}
	}

	@Override
	public void removeSpace() {
		space = null;
		rest = null;
	}

	@Override
	public List<IBuddySpace> getNodeList(Integer limit) {
		List<IBuddySpace> list = new ArrayList<IBuddySpace>();
		if (limit == null) {
			limit = 0;
		}		
		if (isEmpty()) {
			IBuddySpace ps = new BuddySpace();
			ps.setName("");
			ps.setSize(size);
			ps.setType(getType());
			list.add(ps);
		} else {
			if (size > limit) {
				if (left != null) {
					list.addAll(left.getNodeList(limit));
				}
				if (right != null) {
					list.addAll(right.getNodeList(limit));
				}
				if (space != null) {
					list.addAll(space.getNodeList(limit));
				}
				if (rest != null) {
					list.addAll(rest.getNodeList(limit));
				}
			} else {
				IBuddySpace ps = new BuddySpace();
				ps.setName("");
				ps.setSize(size);
				ps.setType(EnumNode.USED);
				list.add(ps);
			}
		}		
		return list;
	}

	@Override
	public List<IBuddyNode> findPossibleBuddyNodes(Integer value) {
		List<IBuddyNode> list = new ArrayList<IBuddyNode>();
		if ((value != null) && (value >= 0)) {
			if (value <= size) {
				Integer ownPotence = BuddyHelper.getPotence(size);
				Integer valuePotence = BuddyHelper.getPotence(value);
				if (ownPotence.equals(valuePotence) && isEmpty()) {					
					list.add(this);									
				} else if ((ownPotence > valuePotence) && (ownPotence > 0) && (space == null)) {
					if ((left == null) && (right == null)) {
						list.add(this);						
					} else {
						if (left != null) {							
							list.addAll(left.findPossibleBuddyNodes(value));
						}
						if (right != null) {
							list.addAll(right.findPossibleBuddyNodes(value));
						}			
					}					
				}			
			}	
		}
		return list;
	}
}
