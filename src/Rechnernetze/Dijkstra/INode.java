/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.List;

public interface INode extends IColorGetter {

	public String getName();
	public void setName(String value);
	
	public INode getPreviousNode();
	public void setPreviousNode(INode node);
	
	public void deletePreviousNode();
	
	public Integer getPreviousWeight();
	
	public Boolean isUsed();
	public void setUsed(Boolean value);
	
	public IEdge getPreviousEdge();
	
	public List<INode> getRoute();
	
	public void addEdge(IEdge edge);
	
	public Boolean hasPreviousNode();
		
	public Boolean isConnected(IEdge edge);
	public Boolean isConnected(INode node);
	
	public void initialize();
}
