package Betriebssysteme.Buddy_Systeme;

import java.util.List;

public interface INode {
	EnumNode getType();
	IBuddyNode getParent();
	void print();
	List<IProcessSpace> getNodeList(List<IProcessSpace> list, Integer limit);
}
