/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface Node {
	public EnumNode getType();
	public BuddyNode getParent();
	public void print();
	public List<BuddySpace> getNodeList(Integer limit);
}
