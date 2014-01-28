/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface INode {
	EnumNode getType();
	IBuddyNode getParent();
	void print();
	List<IBuddySpace> getNodeList(Integer limit);
}
