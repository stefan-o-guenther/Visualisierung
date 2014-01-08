package Betriebssysteme.Buddy_Systeme;

public interface IBuddyNode extends INode {
	Integer getValue();
	Boolean hasChildren();
	
	IBuddyNode getLeftBuddyNode();
	void setLeftBuddyNode(IBuddyNode value);
	
	IBuddyNode getRightBuddyNode();
	void setRightBuddyNode(IBuddyNode value);
	
	ISpaceNode getSpaceNode();
	void setSpaceNode(ISpaceNode value);
	
	IRestNode getRestNode();
	void setRestNode(IRestNode value);
	
	ISpaceNode insertSpace(String name, Integer value);
	
	Boolean isEmpty();
	Boolean clean();
	void removeSpace();
}
