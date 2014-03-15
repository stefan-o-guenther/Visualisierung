/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface IBuddyNode extends INode {
	public Integer getValue();
	public Boolean hasChildren();
	
	public IBuddyNode getLeftBuddyNode();
	public void setLeftBuddyNode(IBuddyNode value);
	
	public IBuddyNode getRightBuddyNode();
	public void setRightBuddyNode(IBuddyNode value);
	
	public IProcessNode getSpaceNode();
	public void setSpaceNode(IProcessNode value);
	
	public IRestNode getRestNode();
	public void setRestNode(IRestNode value);
	
	public IProcessNode insertSpace(String name, Integer value);
	public List<IBuddyNode> findPossibleBuddyNodes(Integer value);
	
	public Boolean isEmpty();
	public Boolean clean();
	public void removeSpace();
}
