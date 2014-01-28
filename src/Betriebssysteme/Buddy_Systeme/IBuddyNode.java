/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface IBuddyNode extends INode {
	Integer getValue();
	Boolean hasChildren();
	
	IBuddyNode getLeftBuddyNode();
	void setLeftBuddyNode(IBuddyNode value);
	
	IBuddyNode getRightBuddyNode();
	void setRightBuddyNode(IBuddyNode value);
	
	IProcessNode getSpaceNode();
	void setSpaceNode(IProcessNode value);
	
	IRestNode getRestNode();
	void setRestNode(IRestNode value);
	
	IProcessNode insertSpace(String name, Integer value);
	List<IBuddyNode> findPossibleBuddyNodes(Integer value);
	
	Boolean isEmpty();
	Boolean clean();
	void removeSpace();
}
