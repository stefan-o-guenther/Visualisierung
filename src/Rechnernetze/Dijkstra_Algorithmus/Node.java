/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;

import java.util.List;

public interface Node extends ColorGetter {

	public String getName();
	public void setName(String value);
	
	public Node getPreviousNode();
	public void setPreviousNode(Node node);
	
	public void deletePreviousNode();
	
	public Integer getPreviousWeight();
	
	public Boolean isUsed();
	public void setUsed(Boolean value);
	
	public Edge getPreviousEdge();
	
	public List<Node> getRoute();
	
	public void addEdge(Edge edge);
	
	public Boolean hasPreviousNode();
		
	public Boolean isConnected(Edge edge);
	public Boolean isConnected(Node node);
	
	public void initialize();
	
	public EnumNodeType getType();
	public void setType(EnumNodeType type);
}
