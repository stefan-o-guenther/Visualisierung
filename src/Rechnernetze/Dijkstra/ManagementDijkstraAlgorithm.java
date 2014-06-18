/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.List;

import Base.EnumVisualizationStatus;
import Base.ManagementAutomatic;

public interface ManagementDijkstraAlgorithm extends ManagementAutomatic {

	public List<Node> getListNodes();
	public List<Edge> getListEdges();
	public Node getNode(String name);
	public Edge getEdge(String nameA, String nameB);
	public Edge getEdge(Node nodeA, Node nodeB);
	
	public Boolean isConnected(String nameA, String nameB);
	public Boolean isConnected(Node nodeA, Node nodeB);
	
	public Integer getMaxTableLines();
	
	public EnumVisualizationStatus getStatus();
	
	public List<String> getListNodeNames();
	public List<List<String>> getListUsedNodes();
	public List<List<NodeOutput>> getListNodesOutput();
	public List<MinOutput> getListMin();
	public List<String> getListRoute();
}
