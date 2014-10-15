/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;

import java.util.List;
import java.util.Map;

import Base.Management;

public interface ManagementDijkstraAlgorithm extends Management {

	public List<String> getListNodeNames();
	public Node getNode(String name);
	public Edge getEdge(String nameA, String nameB);
	
	public Integer getMaxTableLines();	
	
	public List<NodeOutput> getListNodeOutput(String name);
	public List<String> getListNodeTargetNames();
	public List<String> getListNodeUsedNames();
	public Map<String, List<NodeOutput>> getMapNodesOutput();
	
	public List<MinOutput> getListMin();
	public List<String> getListRoute();
	
	public void assume(String start, String target);	
}
