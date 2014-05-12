/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class BuddyNodeImpl implements BuddyNode {

	public BuddyNodeImpl(Integer value, BuddyNode p) {
		if ((value != null) && (value > 0)) {
			Integer x = BuddyHelper.getPotence(value);
			size = (int) Math.pow(2, x);
		} else {
			size = 0;
		}
		parent = p;
	}
	
	private Integer size = 0;
	private BuddyNode left = null;
	private BuddyNode right = null;
	private BuddyNode parent = null;
	private ProcessNode space = null;
	private RestNode rest = null;
	
	@Override
	public Integer getValue() {
		return size;
	}

	@Override
	public Boolean hasChildren() {
		return ((left != null) || (right != null));
	}

	@Override
	public BuddyNode getLeftBuddyNode() {
		return left;
	}

	@Override
	public void setLeftBuddyNode(BuddyNode value) {
		if (value != null) {
			left = value;
		}
	}

	@Override
	public BuddyNode getRightBuddyNode() {
		return right;
	}

	@Override
	public void setRightBuddyNode(BuddyNode value) {
		if (value != null) {
			right = value;
		}
	}
	
	@Override
	public ProcessNode getSpaceNode() {
		return space;
	}

	@Override
	public void setSpaceNode(ProcessNode value) {
		if (value != null) {
			space = value;
		}
	}

	@Override
	public RestNode getRestNode() {
		return rest;
	}

	@Override
	public void setRestNode(RestNode value) {
		if (value != null) {
			rest = value;
		}
	}

	@Override
	public EnumNode getType() {
		return EnumNode.BUDDY;
	}

	@Override
	public BuddyNode getParent() {
		return parent;
	}

	@Override
	public ProcessNode insertSpace(String name, Integer value) {
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
						space = new ProcessNodeImpl(name, value, this);
						rest = new RestNodeImpl(size-value, this);
						return space;
					} else {
						return null;
					}
				} else if ((ownPotence > valuePotence) && (ownPotence > 0)) {
					if (space != null) {
						return null;
					}
					if (left == null) {
						left = new BuddyNodeImpl((size/2), this);
					}
					if (right == null) {
						right = new BuddyNodeImpl((size/2), this);
					}				
					ProcessNode node = left.insertSpace(name, value);
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
	public List<BuddySpace> getNodeList(Integer limit) {
		List<BuddySpace> list = new ArrayList<BuddySpace>();
		if (limit == null) {
			limit = 0;
		}		
		if (isEmpty()) {
			BuddySpace ps = new BuddySpaceImpl();
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
				BuddySpace ps = new BuddySpaceImpl();
				ps.setName("");
				ps.setSize(size);
				ps.setType(EnumNode.USED);
				list.add(ps);
			}
		}		
		return list;
	}

	@Override
	public List<BuddyNode> findPossibleBuddyNodes(Integer value) {
		List<BuddyNode> list = new ArrayList<BuddyNode>();
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
