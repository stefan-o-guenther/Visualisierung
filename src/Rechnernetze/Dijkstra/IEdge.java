/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.Color;

import Base.EnumSurface;

public interface IEdge {

	INode getNodeA();
	void setNodeA(INode value);
	
	INode getNodeB();
	void setNodeB(INode value);
	
	Integer getWeight();
	void setWeight(Integer value);
	
	Boolean isConnected(INode node);
	Boolean isConnected(INode node1, INode node2);
	
	EnumEdgeStatus getStatus();
	void setStatus(EnumEdgeStatus value);
	
	Color getColor(EnumSurface surface);
}
