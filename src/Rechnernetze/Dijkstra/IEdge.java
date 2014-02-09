/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;


public interface IEdge extends IOutput {

	INode getNodeA();
	void setNodeA(INode value);
	
	INode getNodeB();
	void setNodeB(INode value);
	
	Integer getWeight();
	void setWeight(Integer value);
	
	Boolean isConnected(INode node);
	Boolean isConnected(INode node1, INode node2);	
}
