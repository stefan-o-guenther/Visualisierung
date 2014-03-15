/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.List;

import Base.IManagementAutomatic;

public interface IDijkstraAlgorithm extends IManagementAutomatic {

	public List<INode> getListNodes();
	public List<IEdge> getListEdges();
	public INode getNode(String name);
	public IEdge getEdge(String nameA, String nameB);
	public IEdge getEdge(INode nodeA, INode nodeB);
	
	public Boolean isConnected(String nameA, String nameB);
	public Boolean isConnected(INode nodeA, INode nodeB);
	
	public Integer getMaxTableLines();
	
	public EnumDijkstraStatus getStatus();
	
	public List<String> getListNodeNames();
	public List<List<String>> getListUsedNodes();
	public List<List<INodeOutput>> getListNodesOutput();
	public List<IMinOutput> getListMin();
	public List<String> getListRoute();
}
