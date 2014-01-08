package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

public class BuddyNode implements IBuddyNode {

	private Integer size = 0;
	private IBuddyNode left = null;
	private IBuddyNode right = null;
	private IBuddyNode parent = null;
	private ISpaceNode space = null;
	private IRestNode rest = null;
	
	public BuddyNode(Integer value, IBuddyNode p) {
		if ((value != null) && (value > 0)) {
			Integer x = BuddyHelper.getPotence(value);
			size = (int) Math.pow(2, x);
		} else {
			size = 0;
		}
		parent = p;
	}
	
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
	public ISpaceNode getSpaceNode() {
		return space;
	}

	@Override
	public void setSpaceNode(ISpaceNode value) {
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
	public ISpaceNode insertSpace(String name, Integer value) {
		if ((name != null) && (value != null) && (value >= 0)) {
			if (value > size) {
				return null;
			} else {
				Integer x = BuddyHelper.getPotence(size);
				Integer y = BuddyHelper.getPotence(value);
				if (x < y) {
					return null;
				} else if (x.equals(y)) {
					if (isEmpty()) {
						space = new SpaceNode(name, value, this);
						rest = new RestNode(size-value, this);
						return space;
					} else {
						return null;
					}
				} else if ((x > y) && (x > 0)) {
					if (space != null) {
						return null;
					}
					if (left == null) {
						left = new BuddyNode((size/2), this);
					}
					if (right == null) {
						right = new BuddyNode((size/2), this);
					}				
					ISpaceNode node = left.insertSpace(name, value);
					if (node == null) {
						node = right.insertSpace(name, value);					
					}
					return node;
				} else {
					return null;
				}
			}
			/*
			} else	if (value.equals(size)) {
				if (isEmpty()) {
					space = new SpaceNode(name, value, this);
					Integer y = (int) Math.pow(2,size);
					rest = new RestNode(y-value, this);
					return space;
				} else {
					return null;
				}				
			} else	if ((value < size) && (size > 0)) {
				if (space != null) {
					return null;
				}
				if (left == null) {
					left = new BuddyNode((size/2), this);
				}
				if (right == null) {
					right = new BuddyNode((size/2), this);
				}				
				ISpaceNode node = left.insertSpace(name, value);
				if (node == null) {
					node = right.insertSpace(name, value);					
				}
				return node;
			} else {
				return null;
			}
			*/			
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
	public List<IProcessSpace> getNodeList(List<IProcessSpace> list, Integer limit) {
		if (list == null) {
			list = new ArrayList<IProcessSpace>();
		}
		if (limit == null) {
			limit = 0;
		}
		if (isEmpty()) {
			IProcessSpace ps = new ProcessSpace();
			ps.setName("");
			ps.setSize(size);
			ps.setType(getType());
			list.add(ps);
			return list;
		} else {
			if (size > limit) {
				if (left != null) {
					list = left.getNodeList(list, limit);
				}
				if (right != null) {
					list = right.getNodeList(list, limit);
				}
				if (space != null) {
					list = space.getNodeList(list, limit);
				}
				if (rest != null) {
					list = rest.getNodeList(list, limit);
				}
			} else {
				IProcessSpace ps = new ProcessSpace();
				ps.setName("");
				ps.setSize(size);
				ps.setType(EnumNode.USED);
				list.add(ps);
				return list;
			}
		}		
		return list;
	}
}
