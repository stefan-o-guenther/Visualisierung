package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface INode {
	EnumNode getType();
	IBuddyNode getParent();
	void print();
	List<IBuddySpace> getNodeList(Integer limit);
}
