/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
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
	private List<INode> listNodesStart;
	private List<INode> listNodesTarget;
	
	private List<IEdge> listEdges;
	
	private EnumDijkstraStatus status;
	
	private INode nodeFrom;
	private INode nodeStart;
	private INode nodeTarget;
	
	private INode nodeRoute;
	private INode nodeRouteNext;
	
	private INode nodePreviousOld;
	
	private Integer indexNode = -1;
	
	private List<List<INodeOutput>> listlistNodeOutput = new ArrayList<List<INodeOutput>>();
	private HashMap<String, Integer> mapIndex = new HashMap<String, Integer>();
	
	private List<String> listRoute;
	
	private List<List<String>> listlistUsedNodes;
	private List<IMinOutput> listMin;
		
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
		
		listNodesStart = new ArrayList<INode>();
		listNodesTarget = new ArrayList<INode>();
		
		for (INode node : listNodes) {
			if (node != nodeTarget) {
				listNodesStart.add(node);
			}
			if (node != nodeStart) {
				listNodesTarget.add(node);
			}
		}
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
		initEdges();
		initNodes();		
		indexNode = -1;		
		listlistUsedNodes = new ArrayList<List<String>>();
		listMin = new ArrayList<IMinOutput>();
		listRoute = new ArrayList<String>();
		listlistNodeOutput = new ArrayList<List<INodeOutput>>();
		mapIndex = new HashMap<String, Integer>();
		int size = listNodesTarget.size();
		for (int i = 0; i < size; i++) {
			listlistNodeOutput.add(new ArrayList<INodeOutput>());
			INode node = listNodesTarget.get(i);
			mapIndex.put(node.getName(), i);
		}		
	}
	
	private void executeStart() {
		nodeFrom = nodeStart;
		status = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
		executeNodeChain();
	}
	
	private void executeNodeChain() {
		nodeFrom.setUsed(true);
		Integer size = listlistUsedNodes.size();
		List<String> list = null;
		if (size > 0) {
			list = new ArrayList<String>(listlistUsedNodes.get(size-1));
		} else {
			list = new ArrayList<String>();
		}
		list.add(nodeFrom.getName());
		listlistUsedNodes.add(list);
		if (nodeFrom == nodeTarget) {
			nodeRoute = nodeTarget.getPreviousNode();
			nodeRouteNext = nodeTarget;	
			status = EnumDijkstraStatus.ROUTE;
		} else {
			status = EnumDijkstraStatus.EXECUTE_NODE_DISTANCE;
		}		
	}
	
	private Boolean isLastIndex() {
		Integer x = indexNode + 1;
		Integer size = listNodesTarget.size();
		return (size.equals(x));
	}
	
	private void initEdges() {
		for (IEdge edge : listEdges) {
			edge.setStatus(EnumOutputStatus.NORMAL);
		}
	}
	
	private void executeNodeDistance() {
		initEdges();
		if (indexNode < listNodesTarget.size()) {
			indexNode += 1;
			INode nodeTo = listNodesTarget.get(indexNode);
			if ((nodeFrom != null) && (nodeTo != null)) {
				IEdge edge = getEdge(nodeFrom, nodeTo);
				if (edge != null) {
					edge.setStatus(EnumOutputStatus.ACTIVATED);
				}
				if ((nodeTo.isUsed()) || (nodeTo == nodeFrom)) {
					INodeOutput nodeOutput = new NodeOutputMinus();
					List<INodeOutput> list = listlistNodeOutput.get(indexNode);
					list.add(nodeOutput);
					if (isLastIndex()) {
						indexNode = -1;
						status = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
					}
				} else {
					nodePreviousOld = nodeTo.getPreviousNode();
					INodeOutput nodeOutput;
					if (nodeTo.isConnected(nodeFrom)) {
						nodeTo.setPreviousNode(nodeFrom);
					} else {
						nodeTo.deletePreviousNode();
					}
					if (nodeTo.hasPreviousNode()) {
						String previous = nodeTo.getPreviousNode().getName();
						Integer weight = nodeTo.getPreviousWeight();
						nodeOutput = new NodeOutputNormal(previous, weight);
					} else {
						nodeOutput = new NodeOutputInfinity();
					}
					List<INodeOutput> listNodeOutput = listlistNodeOutput.get(indexNode);
					listNodeOutput.add(nodeOutput);
					int sizeList = listNodeOutput.size();
					if (sizeList > 1) {
						INodeOutput nodeOutputA = listNodeOutput.get(sizeList - 2);
						INodeOutput nodeOutputB = listNodeOutput.get(sizeList - 1);
						nodeOutputA.setStatus(EnumOutputStatus.ACTIVATED);
						nodeOutputB.setStatus(EnumOutputStatus.ACTIVATED);
						status = EnumDijkstraStatus.EXECUTE_COMPARE;
					} else if (isLastIndex()) {
						indexNode = -1;
						status = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
					}
				}			
			}			
		}		
	}
	
	private void putOldPreviousNode() {
		INode nodeTo = listNodesTarget.get(indexNode);
		List<INodeOutput> listNodeOutput = listlistNodeOutput.get(indexNode);
		int sizeList = listNodeOutput.size();
		nodeTo.setPreviousNode(nodePreviousOld);
		INodeOutput nodeOutput;
		if (nodeTo.hasPreviousNode()) {
			String previous = nodeTo.getPreviousNode().getName();
			Integer weight = nodeTo.getPreviousWeight();
			nodeOutput = new NodeOutputNormal(previous, weight);
		} else {
			nodeOutput = new NodeOutputInfinity();
		}
		listNodeOutput.remove(sizeList - 1);
		listNodeOutput.add(nodeOutput);
	}
	
	
	private void executeNodeCompare() {
		List<INodeOutput> listNodeOutput = listlistNodeOutput.get(indexNode);
		int sizeList = listNodeOutput.size();
		if (sizeList > 1) {
			INodeOutput nodeOutputOld = listNodeOutput.get(sizeList - 2);
			INodeOutput nodeOutputNew = listNodeOutput.get(sizeList - 1);
			EnumNodeOutputType typeOld = nodeOutputOld.getNodeOutputType();
			EnumNodeOutputType typeNew = nodeOutputNew.getNodeOutputType();			
			if ((typeOld == EnumNodeOutputType.NORMAL) && (typeNew == EnumNodeOutputType.NORMAL)) {
				INodeOutputNormal nodeOutputNormalOld = (INodeOutputNormal) nodeOutputOld;
				INodeOutputNormal nodeOutputNormalNew = (INodeOutputNormal) nodeOutputNew;
				Integer weightOld = nodeOutputNormalOld.getWeightToAccess();
				Integer weightNew = nodeOutputNormalNew.getWeightToAccess();
				if (weightOld <= weightNew) {
					putOldPreviousNode();
				}				
			} else if ((typeOld == EnumNodeOutputType.NORMAL) && (typeNew == EnumNodeOutputType.INFINITY)) {
				putOldPreviousNode();
			} else {
				
			}
			for (INodeOutput nodeOutput : listNodeOutput) {
				nodeOutput.setStatus(EnumOutputStatus.NORMAL);
			}
			if (isLastIndex()) {
				indexNode = -1;
				status = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
			} else {
				status = EnumDijkstraStatus.EXECUTE_NODE_DISTANCE;
			}
		}
	}
	
	private void executeMinNormal() {
		initEdges();
		nodeFrom = null;		
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
		nodeFrom = nodeFound;
		if (nodeFrom == null) {
			status = EnumDijkstraStatus.EXECUTE_MIN_ROUTE;
		} else {
			String name = nodeFrom.getName();
			IMinOutput minOutput = new MinOutputNormal(name);
			listMin.add(minOutput);
			status = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
		}
		
	}
	
	private void executeMinRoute() {
		if (nodeTarget != null) {					
			Integer weight = nodeTarget.getPreviousWeight();
			IMinOutput minOutput = new MinOutputRoute(weight);
			listMin.add(minOutput);
			listRoute.add(nodeTarget.getName());
		}
		status = EnumDijkstraStatus.FINISHED;
	}
	
	
	private void executeRoute() {
		if (nodeRoute != null) {
			listRoute.add(nodeRoute.getName());
			if (nodeRouteNext != null) {
				IEdge edge = getEdge(nodeRoute, nodeRouteNext);
				if (edge != null) {
					edge.setStatus(EnumOutputStatus.ROUTE);
					String key = nodeRouteNext.getName();
					Integer index = mapIndex.get(key);
					List<INodeOutput> list = listlistNodeOutput.get(index);
					INodeOutput nodeOutput = new NodeOutputRoute(edge.getWeight());
					list.add(nodeOutput);
				}
			}
			nodeRouteNext = nodeRoute;
			nodeRoute  = nodeRoute.getPreviousNode();
			if (nodeRoute == null) {
				status = EnumDijkstraStatus.EXECUTE_MIN_ROUTE;
			}
		} else {
			status = EnumDijkstraStatus.EXECUTE_MIN_ROUTE;
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
			case EXECUTE_COMPARE: {
				executeNodeCompare();
				break;
			}
			case EXECUTE_MIN_NORMAL: {
				executeMinNormal();
				break;
			}
			case EXECUTE_MIN_ROUTE: {
				executeMinRoute();
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
		update();
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
		initDijkstra();
		update();
	}

	@Override
	public List<String> getListNodeNames() {
		List<String> listNames = new ArrayList<String>();
		for (INode node : listNodesTarget) {
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
		return new ArrayList<List<INodeOutput>>(listlistNodeOutput);
	}

	@Override
	public List<IMinOutput> getListMin() {
		return new ArrayList<IMinOutput>(listMin);
	}

	@Override
	public List<String> getListRoute() {
		return new ArrayList<String>(listRoute);
	}
}