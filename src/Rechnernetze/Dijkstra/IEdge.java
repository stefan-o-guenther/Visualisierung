package Rechnernetze.Dijkstra;

public interface IEdge {

	INode getNodeFrom();
	void setNodeFrom(INode value);
	
	INode getNodeTo();
	void setNodeTo(INode value);
	
	Integer getWeight();
	void setWeight(Integer value);
}
