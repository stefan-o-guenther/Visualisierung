/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;

public class DijkstraAlgorithm extends BaseManagement implements IDijkstraAlgorithm {
	
	public DijkstraAlgorithm() {
		super();
		nodeStart = nodeU;
		nodeTarget = nodeZ;
		putNodesInList();
		putEdges();
		initDijkstra();		
	}
	
	private INode nodeU = new Node("U");
	private INode nodeV = new Node("V");
	private INode nodeW = new Node("W");
	private INode nodeX = new Node("X");
	private INode nodeY = new Node("Y");
	private INode nodeZ = new Node("Z");
	
	private List<INode> listNodes;
	private List<IEdge> listEdges;
	
	private EnumDijkstraStatus status;
	
	private INode nodeMin;
	private INode nodeStart;
	private INode nodeTarget;
	
	private INode nodeRoute;
	private INode nodeRouteNext;
	
	private Integer indexNode = 0;
	
	private List<List<INodeOutput>> listlistNodesOutput;	
	private List<List<String>> listlistUsedNodes;
	private List<String> listMin;
	private List<String> listRoute;
	
	private void initNodes() {
		nodeU.initialize();
		nodeV.initialize();
		nodeW.initialize();
		nodeX.initialize();
		nodeY.initialize();
		nodeZ.initialize();
	}
	
	private void putNodesInList() {
		listNodes = new ArrayList<INode>();
		listNodes.add(nodeU);
		listNodes.add(nodeV);
		listNodes.add(nodeW);
		listNodes.add(nodeX);
		listNodes.add(nodeY);
		listNodes.add(nodeZ);
	}
	
	private void putEdges() {
		listEdges = new ArrayList<IEdge>();
		listEdges.add(new Edge(nodeU, nodeV, 2));
		listEdges.add(new Edge(nodeU, nodeW, 5));
		listEdges.add(new Edge(nodeU, nodeX, 1));
		listEdges.add(new Edge(nodeV, nodeW, 3));
		listEdges.add(new Edge(nodeV, nodeX, 2));
		listEdges.add(new Edge(nodeW, nodeX, 3));
		listEdges.add(new Edge(nodeW, nodeY, 1));
		listEdges.add(new Edge(nodeW, nodeZ, 5));
		listEdges.add(new Edge(nodeX, nodeY, 1));
		listEdges.add(new Edge(nodeY, nodeZ, 2));
	}
	
	
	private void initDijkstra() {
		status = EnumDijkstraStatus.START;
		initNodes();		
		indexNode = -1;		
		listlistUsedNodes = new ArrayList<List<String>>();
		listMin = new ArrayList<String>();
		listRoute = new ArrayList<String>();
		listlistNodesOutput = new ArrayList<List<INodeOutput>>();
	}
	
	private INode findNodeWithShortestPath() {
		INode nodeFound = null;
		Integer min = null;
		for (INode node : listNodes) {
			if ((node.hasPreviousNode()) && (!(node.isUsed()))) {
				if (nodeFound == null) {
					nodeFound = node;
					min = node.getPreviousWeight();
				} else {
					Integer x = node.getPreviousWeight();
					if (x < min) {
						nodeFound = node;
						min = x;
					}
				}
			}
		}
		return nodeFound;
	}	
	
	private void executeStart() {
		nodeMin = nodeStart;
		status = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
		executeNodeChain();
	}
	
	private void executeNodeChain() {
		nodeMin.setUsed(true);
		Integer size = listlistUsedNodes.size();
		List<String> list = null;
		if (size > 0) {
			list = new ArrayList<String>(listlistUsedNodes.get(size-1));
		} else {
			list = new ArrayList<String>();
		}
		list.add(nodeMin.getName());
		listlistUsedNodes.add(list);
		status = EnumDijkstraStatus.EXECUTE_NODE_DISTANCE;
	}
	
	private Boolean isLastIndex() {
		Integer x = indexNode + 1;
		Integer size = listNodes.size();
		return (size.equals(x));
	}
	
	private void initEdges() {
		for (IEdge edge : listEdges) {
			edge.setStatus(EnumEdgeStatus.NORMAL);
		}
	}
	
	private void executeNodeDistance() {
		if (indexNode < listNodes.size()) {
			indexNode += 1;
			if (indexNode.equals(0)) {
				listlistNodesOutput.add(new ArrayList<INodeOutput>());
			}
			INode node = listNodes.get(indexNode);
			nodeMin.execute(node);
			initEdges();
			IEdge edge = getEdge(nodeMin, node);
			if (edge != null) {
				edge.setStatus(EnumEdgeStatus.ACTIVATED);
			}			
			INodeOutput nodeOutput = new NodeOutput();
			if ((nodeMin == node) || (node.isUsed())) {
				nodeOutput.setPreviousNodeType(EnumPreviousType.MINUS);
			} else if (node.hasPreviousNode()) {
				nodeOutput.setPreviousNodeType(EnumPreviousType.NORMAL);
				nodeOutput.setPreviousNodeName(node.getPreviousNode().getName());
				nodeOutput.setWeightToAccess(node.getPreviousWeight());
			} else {
				nodeOutput.setPreviousNodeType(EnumPreviousType.INFINITY);
			}
			Integer size = listlistNodesOutput.size();
			List<INodeOutput> listOutput = listlistNodesOutput.get(size-1);
			if (listOutput == null) {
				listOutput = new ArrayList<INodeOutput>();
			}
			listOutput.add(nodeOutput);
			if (isLastIndex()) {
				indexNode = -1;
				status = EnumDijkstraStatus.EXECUTE_FIND_MIN;
			}
		}		
	}
	
	private void executeFindMin() {
		initEdges();
		nodeMin = findNodeWithShortestPath();	
		if (nodeMin == null) {			
			listMin.add("-");
			status = EnumDijkstraStatus.ROUTE;
		} else {
			listMin.add(nodeMin.getName());			
			status = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
			nodeRoute = nodeTarget;
			nodeRouteNext = null;
		}
	}
	
	private void executeRoute() {		
		if (nodeRoute != null) {
			listRoute.add(nodeRoute.getName());
			if (nodeRouteNext != null) {
				IEdge edge = getEdge(nodeRoute, nodeRouteNext);
				if (edge != null) {
					edge.setStatus(EnumEdgeStatus.ROUTE);
				}
			}
			nodeRouteNext = nodeRoute;
			nodeRoute  = nodeRoute.getPreviousNode();
			if (nodeRoute == null) {
				status = EnumDijkstraStatus.FINISHED;
			}
		}	
	}
		
	@Override
	public void execute() {
		switch (status) {
			case START: {
				executeStart();
				break;
			}
			case EXECUTE_NODE_CHAIN: {
				executeNodeChain();
				break;
			}
			case EXECUTE_NODE_DISTANCE: {
				executeNodeDistance();
				break;
			}
			case EXECUTE_FIND_MIN: {
				executeFindMin();
				break;
			}
			case ROUTE: {
				executeRoute();
				break;
			}
			case FINISHED: {				
				break;
			}
			default: {
				break;
			}
		}
	}	

	@Override
	public List<INode> getListNodes() {
		return new ArrayList<INode>(listNodes);
	}

	@Override
	public List<IEdge> getListEdges() {
		return listEdges;
	}

	@Override
	public INode getNode(String name) {
		if (name != null) {
			for (INode node : listNodes) {
				if (name.equals(node.getName())) {
					return node;
				}
			}
		}		
		return null;
	}

	@Override
	public IEdge getEdge(String nameA, String nameB) {
		if ((nameA != null) && (nameB != null)) {
			INode nodeA = getNode(nameA);
			INode nodeB = getNode(nameB);
			if ((nodeA != null) && (nodeB != null)) {
				return getEdge(nodeA, nodeB);
			}
		}
		return null;
	}
	
	@Override
	public IEdge getEdge(INode nodeA, INode nodeB) {
		if ((nodeA != null) && (nodeB != null)) {
			for (IEdge edge : listEdges) {
				if (edge.isConnected(nodeA, nodeB)) {
					return edge;
				}
			}
		}
		return null;
	}

	

	@Override
	public Boolean isConnected(String nameA, String nameB) {
		if ((nameA != null) && (nameB != null)) {
			IEdge edge = getEdge(nameA, nameB);
			if (edge != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean isConnected(INode nodeA, INode nodeB) {
		if ((nodeA != null) && (nodeB != null)) {
			IEdge edge = getEdge(nodeA, nodeB);
			if (edge != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public EnumDijkstraStatus getStatus() {
		return status;
	}

	@Override
	public Integer getMaxTableLines() {
		return listNodes.size();
	}
	
	@Override
	public void reset() {
		this.initDijkstra();
	}

	@Override
	public List<String> getListNodeNames() {
		List<String> listNames = new ArrayList<String>();
		for (INode node : listNodes) {
			listNames.add(node.getName());
		}
		return listNames;
	}

	@Override
	public List<List<String>> getListUsedNodes() {
		return new ArrayList<List<String>>(this.listlistUsedNodes);
	}

	@Override
	public List<List<INodeOutput>> getListNodesOutput() {
		return new ArrayList<List<INodeOutput>>(listlistNodesOutput);
	}

	@Override
	public List<String> getListMin() {
		return new ArrayList<String>(listMin);
	}

	@Override
	public List<String> getListRoute() {
		return new ArrayList<String>(listRoute);
	}
}