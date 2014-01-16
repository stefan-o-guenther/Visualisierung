package Rechnernetze.Dijkstra;

import java.util.List;

public interface INode {

	EnumNodeType getType();
	void setType(EnumNodeType value);
	
	String getName();
	void setName(String value);
	
	IEdge getPreviousEdge();
	void setPreviousEdge(IEdge value);
	
	List<IEdge> getListEdges();
	void setListEdges(List<IEdge> value);
	
	INode getPreviousNode();
	Integer getPreviousWeight();
	
	void addEdge(IEdge value);
}
