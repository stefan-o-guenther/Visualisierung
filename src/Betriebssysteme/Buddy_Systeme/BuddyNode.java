/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface BuddyNode extends Node {
	public Integer getValue();
	public Boolean hasChildren();
	
	public BuddyNode getLeftBuddyNode();
	public void setLeftBuddyNode(BuddyNode value);
	
	public BuddyNode getRightBuddyNode();
	public void setRightBuddyNode(BuddyNode value);
	
	public ProcessNode getSpaceNode();
	public void setSpaceNode(ProcessNode value);
	
	public RestNode getRestNode();
	public void setRestNode(RestNode value);
	
	public ProcessNode insertSpace(String name, Integer value);
	public List<BuddyNode> findPossibleBuddyNodes(Integer value);
	
	public Boolean isEmpty();
	public Boolean clean();
	public void removeSpace();
}
