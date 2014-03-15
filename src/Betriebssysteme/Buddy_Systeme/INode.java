/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface INode {
	public EnumNode getType();
	public IBuddyNode getParent();
	public void print();
	public List<IBuddySpace> getNodeList(Integer limit);
}
