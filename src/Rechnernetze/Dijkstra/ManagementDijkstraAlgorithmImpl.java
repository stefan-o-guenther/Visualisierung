/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;
import Base.PanelAbstract;
import Base.PanelMenuControlBoxImpl;

public class ManagementDijkstraAlgorithmImpl extends ManagementAbstract implements ManagementDijkstraAlgorithm {
	
	public ManagementDijkstraAlgorithmImpl() {
		super();
	}
	
	private Node nodeU;
	private Node nodeV;
	private Node nodeW;
	private Node nodeX;
	private Node nodeY;
	private Node nodeZ;
	
	private List<Node> listNodes;	
	private List<Node> listNodesStart;
	private List<Node> listNodesTarget;
	
	private List<Edge> listEdges;
	
	private EnumDijkstraStatus statusDijkstra;
	private EnumVisualizationStatus status;
	
	private Node nodeFrom;
	private Node nodeStart;
	private Node nodeTarget;
	
	private Node nodeRoute;
	private Node nodeRouteNext;
	
	private Node nodePreviousOld;
	
	private Integer indexNode = -1;
	
	private List<List<NodeOutput>> listlistNodeOutput;
	private HashMap<String, Integer> mapIndex;
	
	private List<String> listRoute;
	
	private List<List<String>> listlistUsedNodes;
	private List<MinOutput> listMin;

	@Override
	protected void create() {
		this.listlistNodeOutput = new ArrayList<List<NodeOutput>>();
		this.mapIndex = new HashMap<String, Integer>();
		this.createNodes();
		this.putNodesInList();
		this.putEdges();
	}
	
	@Override
	protected void initialize() {
		status = EnumVisualizationStatus.RUN;
		statusDijkstra = EnumDijkstraStatus.EXECUTE_START;		
		setAutomaticChecked(false);
		setAutomaticRunning(false);
		initEdges();
		initNodes();		
		indexNode = -1;		
		listlistUsedNodes = new ArrayList<List<String>>();
		listMin = new ArrayList<MinOutput>();
		listRoute = new ArrayList<String>();
		listlistNodeOutput = new ArrayList<List<NodeOutput>>();
		mapIndex = new HashMap<String, Integer>();
		int size = listNodesTarget.size();
		for (int i = 0; i < size; i++) {
			listlistNodeOutput.add(new ArrayList<NodeOutput>());
			Node node = listNodesTarget.get(i);
			mapIndex.put(node.getName(), i);
		}		
	}
	
	private void initEdges() {
		for (Edge edge : listEdges) {
			edge.setStatus(EnumOutputStatus.NORMAL);
		}
	}
	
	private void initNodes() {
		nodeU.initialize();
		nodeV.initialize();
		nodeW.initialize();
		nodeX.initialize();
		nodeY.initialize();
		nodeZ.initialize();
	}
	
	private void createNodes() {
		Integer difX = 200;
		Integer difY = 70;		
		
		Integer x1 = 10;
		Integer x2 = x1 + 850;
		Integer x3 = x1 + difX;
		Integer x4 = x2 - difX;		
		Integer y1 = 110;
		Integer y2 = y1 - difY;
		Integer y3 = y1 + difY;
		
		nodeU = new NodeImpl("U", x1, y1);
		nodeV = new NodeImpl("V", x3, y2);
		nodeW = new NodeImpl("W", x4, y2);
		nodeX = new NodeImpl("X", x3, y3);
		nodeY = new NodeImpl("Y", x4, y3);
		nodeZ = new NodeImpl("Z", x2, y1);		
		
		nodeStart = nodeU;
		nodeTarget = nodeZ;		
	}
	
	private void putNodesInList() {
		listNodes = new ArrayList<Node>();
		listNodes.add(nodeU);
		listNodes.add(nodeV);
		listNodes.add(nodeW);
		listNodes.add(nodeX);
		listNodes.add(nodeY);
		listNodes.add(nodeZ);
		
		listNodesStart = new ArrayList<Node>();
		listNodesTarget = new ArrayList<Node>();
		
		for (Node node : listNodes) {
			if (node != nodeTarget) {
				listNodesStart.add(node);
			}
			if (node != nodeStart) {
				listNodesTarget.add(node);
			}
		}
	}
	
	private void putEdges() {
		listEdges = new ArrayList<Edge>();
		listEdges.add(new EdgeImpl(nodeU, nodeV, 2));
		listEdges.add(new EdgeImpl(nodeU, nodeW, 5));
		listEdges.add(new EdgeImpl(nodeU, nodeX, 1));
		listEdges.add(new EdgeImpl(nodeV, nodeW, 3));
		listEdges.add(new EdgeImpl(nodeV, nodeX, 2));
		listEdges.add(new EdgeImpl(nodeW, nodeX, 3));
		listEdges.add(new EdgeImpl(nodeW, nodeY, 1));
		listEdges.add(new EdgeImpl(nodeW, nodeZ, 5));
		listEdges.add(new EdgeImpl(nodeX, nodeY, 1));
		listEdges.add(new EdgeImpl(nodeY, nodeZ, 2));
	}	
	
	private void executeStart() {
		nodeFrom = nodeStart;
		statusDijkstra = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
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
			statusDijkstra = EnumDijkstraStatus.EXECUTE_ROUTE;
		} else {
			statusDijkstra = EnumDijkstraStatus.EXECUTE_NODE_DISTANCE;
		}		
	}
	
	private Boolean isLastIndex() {
		Integer x = indexNode + 1;
		Integer size = listNodesTarget.size();
		return (size.equals(x));
	}
	
	private void executeNodeDistance() {
		initEdges();
		if (indexNode < listNodesTarget.size()) {
			indexNode += 1;
			Node nodeTo = listNodesTarget.get(indexNode);
			if ((nodeFrom != null) && (nodeTo != null)) {
				Edge edge = getEdge(nodeFrom, nodeTo);
				if (edge != null) {
					edge.setStatus(EnumOutputStatus.ACTIVATED);
				}
				if ((nodeTo.isUsed()) || (nodeTo == nodeFrom)) {
					NodeOutput nodeOutput = new NodeOutputMinusImpl();
					List<NodeOutput> list = listlistNodeOutput.get(indexNode);
					list.add(nodeOutput);
					if (isLastIndex()) {
						indexNode = -1;
						statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
					}
				} else {
					nodePreviousOld = nodeTo.getPreviousNode();
					NodeOutput nodeOutput;
					if (nodeTo.isConnected(nodeFrom)) {
						nodeTo.setPreviousNode(nodeFrom);
					} else {
						nodeTo.deletePreviousNode();
					}
					if (nodeTo.hasPreviousNode()) {
						String previous = nodeTo.getPreviousNode().getName();
						Integer weight = nodeTo.getPreviousWeight();
						nodeOutput = new NodeOutputNormalImpl(previous, weight);
					} else {
						nodeOutput = new NodeOutputInfinityImpl();
					}
					List<NodeOutput> listNodeOutput = listlistNodeOutput.get(indexNode);
					listNodeOutput.add(nodeOutput);
					int sizeList = listNodeOutput.size();
					if (sizeList > 1) {
						NodeOutput nodeOutputA = listNodeOutput.get(sizeList - 2);
						NodeOutput nodeOutputB = listNodeOutput.get(sizeList - 1);
						nodeOutputA.setStatus(EnumOutputStatus.ACTIVATED);
						nodeOutputB.setStatus(EnumOutputStatus.ACTIVATED);
						statusDijkstra = EnumDijkstraStatus.EXECUTE_COMPARE;
					} else if (isLastIndex()) {
						indexNode = -1;
						statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
					}
				}			
			}			
		}		
	}
	
	private void putOldPreviousNode() {
		Node nodeTo = listNodesTarget.get(indexNode);
		List<NodeOutput> listNodeOutput = listlistNodeOutput.get(indexNode);
		int sizeList = listNodeOutput.size();
		nodeTo.setPreviousNode(nodePreviousOld);
		NodeOutput nodeOutput;
		if (nodeTo.hasPreviousNode()) {
			String previous = nodeTo.getPreviousNode().getName();
			Integer weight = nodeTo.getPreviousWeight();
			nodeOutput = new NodeOutputNormalImpl(previous, weight);
		} else {
			nodeOutput = new NodeOutputInfinityImpl();
		}
		listNodeOutput.remove(sizeList - 1);
		listNodeOutput.add(nodeOutput);
	}
	
	
	private void executeNodeCompare() {
		List<NodeOutput> listNodeOutput = listlistNodeOutput.get(indexNode);
		int sizeList = listNodeOutput.size();
		if (sizeList > 1) {
			NodeOutput nodeOutputOld = listNodeOutput.get(sizeList - 2);
			NodeOutput nodeOutputNew = listNodeOutput.get(sizeList - 1);
			EnumNodeOutputType typeOld = nodeOutputOld.getNodeOutputType();
			EnumNodeOutputType typeNew = nodeOutputNew.getNodeOutputType();			
			if ((typeOld == EnumNodeOutputType.NORMAL) && (typeNew == EnumNodeOutputType.NORMAL)) {
				NodeOutputNormal nodeOutputNormalOld = (NodeOutputNormal) nodeOutputOld;
				NodeOutputNormal nodeOutputNormalNew = (NodeOutputNormal) nodeOutputNew;
				Integer weightOld = nodeOutputNormalOld.getWeightToAccess();
				Integer weightNew = nodeOutputNormalNew.getWeightToAccess();
				if (weightOld <= weightNew) {
					putOldPreviousNode();
				}				
			} else if ((typeOld == EnumNodeOutputType.NORMAL) && (typeNew == EnumNodeOutputType.INFINITY)) {
				putOldPreviousNode();
			} else {
				
			}
			for (NodeOutput nodeOutput : listNodeOutput) {
				nodeOutput.setStatus(EnumOutputStatus.NORMAL);
			}
			if (isLastIndex()) {
				indexNode = -1;
				statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
			} else {
				statusDijkstra = EnumDijkstraStatus.EXECUTE_NODE_DISTANCE;
			}
		}
	}
	
	private void executeMinNormal() {
		initEdges();
		nodeFrom = null;		
		Node nodeFound = null;
		Integer min = null;
		for (Node node : listNodes) {
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
			statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_ROUTE;
		} else {
			String name = nodeFrom.getName();
			MinOutput minOutput = new MinOutputNormalImpl(name);
			listMin.add(minOutput);
			statusDijkstra = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
		}
		
	}
	
	private void executeMinRoute() {
		if (nodeTarget != null) {					
			Integer weight = nodeTarget.getPreviousWeight();
			MinOutput minOutput = new MinOutputRouteImpl(weight);
			listMin.add(minOutput);
			listRoute.add(nodeTarget.getName());
		}
		this.executeFinish();
	}
	
	
	private void executeRoute() {
		if (nodeRoute != null) {
			listRoute.add(nodeRoute.getName());
			if (nodeRouteNext != null) {
				Edge edge = getEdge(nodeRoute, nodeRouteNext);
				if (edge != null) {
					edge.setStatus(EnumOutputStatus.ROUTE);
					String key = nodeRouteNext.getName();
					Integer index = mapIndex.get(key);
					List<NodeOutput> list = listlistNodeOutput.get(index);
					NodeOutput nodeOutput = new NodeOutputRouteImpl(edge.getWeight());
					list.add(nodeOutput);
				}
			}
			nodeRouteNext = nodeRoute;
			nodeRoute  = nodeRoute.getPreviousNode();
			if (nodeRoute == null) {
				statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_ROUTE;
			}
		} else {
			statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_ROUTE;
		}
	}
	
	private void executeFinish() {
		status = EnumVisualizationStatus.FINISHED;
		this.stopAutomatic();		
	}
		
	@Override
	protected Boolean execute() {
		if (status == EnumVisualizationStatus.RUN) {
			switch (statusDijkstra) {
				case EXECUTE_START: {
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
				case EXECUTE_ROUTE: {
					executeRoute();
					break;
				}
				default: {
					break;
				}			
			}		
		}
		this.updateAllPanels();
		return true;
	}	

	@Override
	public List<Node> getListNodes() {
		return new ArrayList<Node>(listNodes);
	}

	@Override
	public List<Edge> getListEdges() {
		return listEdges;
	}

	@Override
	public Node getNode(String name) {
		if (name != null) {
			for (Node node : listNodes) {
				if (name.equals(node.getName())) {
					return node;
				}
			}
		}		
		return null;
	}

	@Override
	public Edge getEdge(String nameA, String nameB) {
		if ((nameA != null) && (nameB != null)) {
			Node nodeA = getNode(nameA);
			Node nodeB = getNode(nameB);
			if ((nodeA != null) && (nodeB != null)) {
				return getEdge(nodeA, nodeB);
			}
		}
		return null;
	}
	
	@Override
	public Edge getEdge(Node nodeA, Node nodeB) {
		if ((nodeA != null) && (nodeB != null)) {
			for (Edge edge : listEdges) {
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
			Edge edge = getEdge(nameA, nameB);
			if (edge != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean isConnected(Node nodeA, Node nodeB) {
		if ((nodeA != null) && (nodeB != null)) {
			Edge edge = getEdge(nodeA, nodeB);
			if (edge != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public EnumVisualizationStatus getStatus() {
		return status;
	}

	@Override
	public Integer getMaxTableLines() {
		return listNodes.size();
	}
	
	@Override
	public List<String> getListNodeNames() {
		List<String> listNames = new ArrayList<String>();
		for (Node node : listNodesTarget) {
			listNames.add(node.getName());
		}
		return listNames;
	}

	@Override
	public List<List<String>> getListUsedNodes() {
		return new ArrayList<List<String>>(this.listlistUsedNodes);
	}

	@Override
	public List<List<NodeOutput>> getListNodesOutput() {
		return new ArrayList<List<NodeOutput>>(listlistNodeOutput);
	}

	@Override
	public List<MinOutput> getListMin() {
		return new ArrayList<MinOutput>(listMin);
	}

	@Override
	public List<String> getListRoute() {
		return new ArrayList<String>(listRoute);
	}

	@Override
	public String getTitle() {
		return "Dijkstra";
	}

	@Override
	protected void showErrorMessage() {
				
	}

	@Override
	protected void updateSize() {
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	public Integer getAutomaticSpace() {
		return 0;
	}

	@Override
	protected void createPanelMenu() {
		PanelAbstract panelLeft = new PanelRNDijkstraAlgorithmMenuImpl(this);
		PanelAbstract panelRight = new PanelMenuControlBoxImpl(this);
		this.panelMenu = this.getPanelCouple(panelLeft, panelRight);
	}

	@Override
	protected void createPanelModel() {
		panelModel = new PanelRNDijkstraAlgorithmModelImpl(this);
	}

	@Override
	protected void createToolTipManager() {
		tooltip = new ToolTipManagerDijkstraAlgorithmImpl();
	}
}