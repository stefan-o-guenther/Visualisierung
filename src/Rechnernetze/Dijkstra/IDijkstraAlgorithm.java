/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.List;

import Base.IManagementAutomatic;

public interface IDijkstraAlgorithm extends IManagementAutomatic {

	List<INode> getListNodes();
	List<IEdge> getListEdges();
	INode getNode(String name);
	IEdge getEdge(String nameA, String nameB);
	IEdge getEdge(INode nodeA, INode nodeB);
	
	Boolean isConnected(String nameA, String nameB);
	Boolean isConnected(INode nodeA, INode nodeB);
	
	Integer getMaxTableLines();
	
	EnumDijkstraStatus getStatus();
	
	List<String> getListNodeNames();
	List<List<String>> getListUsedNodes();
	List<List<INodeOutput>> getListNodesOutput();
	List<IMinOutput> getListMin();
	List<String> getListRoute();
}
