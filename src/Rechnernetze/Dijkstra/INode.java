/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.Color;
import java.util.List;

import Base.EnumSurface;

public interface INode {

	String getName();
	void setName(String value);
	
	INode getPreviousNode();
	void setPreviousNode(INode node);
	
	Integer getPreviousWeight();
	
	Boolean isUsed();
	void setUsed(Boolean value);
	
	IEdge getPreviousEdge();
	
	List<INode> getRoute();
	
	//void setPreviousEdge(IEdge edge);
	
	//List<IEdge> getListEdges();
	//void setListEdges(List<IEdge> value);	
	
	void addEdge(IEdge edge);
	
	Boolean hasPreviousNode();
	
	//void execute();
	void execute(INode node);
	
	Boolean isConnected(IEdge edge);
	Boolean isConnected(INode node);
	
	void initialize();
	
	Color getColor(EnumSurface surface);
}
