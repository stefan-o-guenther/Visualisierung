/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.List;

public interface INode extends IColorGetter {

	String getName();
	void setName(String value);
	
	INode getPreviousNode();
	void setPreviousNode(INode node);
	
	void deletePreviousNode();
	
	Integer getPreviousWeight();
	
	Boolean isUsed();
	void setUsed(Boolean value);
	
	IEdge getPreviousEdge();
	
	List<INode> getRoute();
	
	void addEdge(IEdge edge);
	
	Boolean hasPreviousNode();
		
	Boolean isConnected(IEdge edge);
	Boolean isConnected(INode node);
	
	void initialize();
}
