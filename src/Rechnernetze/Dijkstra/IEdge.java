/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;


public interface IEdge extends IOutput {

	public INode getNodeA();
	public void setNodeA(INode value);
	
	public INode getNodeB();
	public void setNodeB(INode value);
	
	public Integer getWeight();
	public void setWeight(Integer value);
	
	public Boolean isConnected(INode node);
	public Boolean isConnected(INode node1, INode node2);	
}
