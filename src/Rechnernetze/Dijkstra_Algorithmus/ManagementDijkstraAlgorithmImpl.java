/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;
import Base.MessageBox;
import Base.ToolTipManager;

public class ManagementDijkstraAlgorithmImpl extends ManagementAbstract implements ManagementDijkstraAlgorithm {
	
    public ManagementDijkstraAlgorithmImpl() {
    	super();
    }
	
	private Map<String, Node> mapNodes;
	
	private List<Edge> listEdges;
	
	private EnumDijkstraStatus statusDijkstra;
	
	private Node nodeFrom;
	
	private Node nodeRoute;
	private Node nodeRouteNext;
	
	private Node nodePreviousOld;
	
	private int indexTargetNode;
	
	private Map<String, List<NodeOutput>> mapNodesOutput;	
	private List<String> listRoute;	
	private List<String> listNodeUsedNames;
	private List<MinOutput> listMin;
	private List<String> listNodeNames;
	private List<String> listNodeTargetNames;

	@Override
	protected void create() {
		this.initNodeNames();
		this.createNodes();
		this.putEdges();
	}
	
	@Override
	protected void initialize() {
		statusDijkstra = EnumDijkstraStatus.EXECUTE_START;
		updateListNodeTargetNames();
		initEdges();
		initNodes();
		initMapNodesOutput();		
		indexTargetNode = -1;
		listNodeUsedNames = new ArrayList<String>();
		listMin = new ArrayList<MinOutput>();
		listRoute = new ArrayList<String>();
	}
	
	private void initNodeNames() {
		listNodeNames = new ArrayList<String>();
		listNodeNames.add("U");
		listNodeNames.add("V");
		listNodeNames.add("W");
		listNodeNames.add("X");
		listNodeNames.add("Y");
		listNodeNames.add("Z");
	}
	
	private void initMapNodesOutput() {
		this.mapNodesOutput = new HashMap<String, List<NodeOutput>>();
		List<String> listNames = new ArrayList<String>(this.mapNodes.keySet());
		for (String name : listNames) {
			this.mapNodesOutput.put(name, new ArrayList<NodeOutput>());
		}
	}
	
	private void initEdges() {
		for (Edge edge : listEdges) {
			edge.setStatus(EnumOutputStatus.NORMAL);
		}
	}
	
	private void initNodes() {
		for (String name : getListNodeNames()) {
			Node node = this.getNode(name);
			node.initialize();
		}
	}
	
	private Node getNodeStart() {
		Node node = null;
		for (String name : this.listNodeNames) {
			Node nodeTest = this.mapNodes.get(name);
			if (nodeTest.getType() == EnumNodeType.START) {
				node = nodeTest;
			}
		}
		return node;
	}
	
	private Node getNodeTarget() {
		Node node = null;
		for (String name : this.listNodeNames) {
			Node nodeTest = this.mapNodes.get(name);
			if (nodeTest.getType() == EnumNodeType.TARGET) {
				node = nodeTest;
			}
		}
		return node;
	}
	
	private void createNodes() {
		String name;
		this.mapNodes = new HashMap<String, Node>();
		name = this.listNodeNames.get(0);
		this.mapNodes.put(name, new NodeImpl(name));
		name = this.listNodeNames.get(1);
		this.mapNodes.put(name, new NodeImpl(name));
		name = this.listNodeNames.get(2);
		this.mapNodes.put(name, new NodeImpl(name));
		name = this.listNodeNames.get(3);
		this.mapNodes.put(name, new NodeImpl(name));
		name = this.listNodeNames.get(4);
		this.mapNodes.put(name, new NodeImpl(name));
		name = this.listNodeNames.get(5);
		this.mapNodes.put(name, new NodeImpl(name));
	}
	
	private void putEdges() {
		Node node0 = mapNodes.get(listNodeNames.get(0));	// U
		Node node1 = mapNodes.get(listNodeNames.get(1));	// V
		Node node2 = mapNodes.get(listNodeNames.get(2));	// W
		Node node3 = mapNodes.get(listNodeNames.get(3));	// X
		Node node4 = mapNodes.get(listNodeNames.get(4));	// Y
		Node node5 = mapNodes.get(listNodeNames.get(5));	// Z
		
		
		this.listEdges = new ArrayList<Edge>();
		this.listEdges.add(new EdgeImpl(node0, node1, 2));
		this.listEdges.add(new EdgeImpl(node0, node2, 5));
		this.listEdges.add(new EdgeImpl(node0, node3, 1));
		this.listEdges.add(new EdgeImpl(node1, node2, 3));
		this.listEdges.add(new EdgeImpl(node1, node3, 2));
		this.listEdges.add(new EdgeImpl(node2, node3, 3));
		this.listEdges.add(new EdgeImpl(node2, node4, 1));
		this.listEdges.add(new EdgeImpl(node2, node5, 5));
		this.listEdges.add(new EdgeImpl(node3, node4, 1));
		this.listEdges.add(new EdgeImpl(node4, node5, 2));
	}	
	
	private void executeStart() {
		nodeFrom = this.getNodeStart();
		statusDijkstra = EnumDijkstraStatus.EXECUTE_NODE_CHAIN;
		executeNodeChain();
	}
	
	private void executeNodeChain() {
		nodeFrom.setUsed(true);
		listNodeUsedNames.add(nodeFrom.getName());
		if (nodeFrom.getType() == EnumNodeType.TARGET) {
			nodeRoute = nodeFrom.getPreviousNode();
			nodeRouteNext = nodeFrom;						
			statusDijkstra = EnumDijkstraStatus.EXECUTE_ROUTE;
		} else {
			statusDijkstra = EnumDijkstraStatus.EXECUTE_NODE_DISTANCE;
		}		
	}
	
	private Boolean isLastIndex() {
		List<String> listNodesTarget = this.getListNodeTargetNames();
		Integer x = indexTargetNode + 1;
		Integer size = listNodesTarget.size();
		return (size.equals(x));
	}
	
	private void updateListNodeTargetNames() {
		listNodeTargetNames = new ArrayList<String>();
		if ((this.getNodeStart() != null) && (this.getNodeTarget() != null)) {
			List<String> listNodeNames = this.getListNodeNames();
			for (String name : listNodeNames) {
				Node node = this.mapNodes.get(name);
				if (node.getType() != EnumNodeType.START) {
					listNodeTargetNames.add(name);
				}
			}
		}
	}
	
	private void executeNodeDistance() {
		initEdges();
		List<String> listNodesTarget = getListNodeTargetNames();
		indexTargetNode += 1;
		if (indexTargetNode < listNodesTarget.size()) {
			String nameTo = listNodesTarget.get(indexTargetNode);
			Node nodeTo = this.getNode(nameTo);
			if ((nodeFrom != null) && (nodeTo != null)) {
				Edge edge = getEdge(nodeFrom.getName(), nameTo);
				if (edge != null) {
					edge.setStatus(EnumOutputStatus.ACTIVATED);
				}
				if ((nodeTo.isUsed()) || (nodeTo == nodeFrom)) {
					NodeOutput nodeOutput = new NodeOutputMinusImpl();
					List<NodeOutput> list = getListNodeOutput(nodeTo.getName());
					list.add(nodeOutput);
					if (isLastIndex()) {
						indexTargetNode = -1;
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
					List<NodeOutput> listNodeOutput = getListNodeOutput(nodeTo.getName());
					listNodeOutput.add(nodeOutput);
					int sizeList = listNodeOutput.size();
					if (sizeList > 1) {
						NodeOutput nodeOutputA = listNodeOutput.get(sizeList - 2);
						NodeOutput nodeOutputB = listNodeOutput.get(sizeList - 1);
						nodeOutputA.setStatus(EnumOutputStatus.ACTIVATED);
						nodeOutputB.setStatus(EnumOutputStatus.ACTIVATED);
						statusDijkstra = EnumDijkstraStatus.EXECUTE_COMPARE;
					} else if (isLastIndex()) {
						indexTargetNode = -1;
						statusDijkstra = EnumDijkstraStatus.EXECUTE_MIN_NORMAL;
					}
				}			
			}			
		}		
	}
	
	private void putOldPreviousNode() {
		List<String> listNodesTarget = this.getListNodeTargetNames();
		String nameTo = listNodesTarget.get(indexTargetNode);
		Node nodeTo = this.getNode(nameTo);
		List<NodeOutput> listNodeOutput = getListNodeOutput(nameTo);
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
		List<String> listNodesTarget = this.getListNodeTargetNames();
		String nameTo = listNodesTarget.get(indexTargetNode);
		List<NodeOutput> listNodeOutput = this.getListNodeOutput(nameTo);
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
				indexTargetNode = -1;
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
		for (String name : getListNodeNames()) {
			Node node = this.getNode(name);
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
		Node nodeTarget = this.getNodeTarget();
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
			String nodeRouteName = nodeRoute.getName();
			listRoute.add(nodeRouteName);
			if (nodeRouteNext != null) {
				String nodeRouteNextName = nodeRouteNext.getName();
				Edge edge = getEdge(nodeRouteName, nodeRouteNextName);
				if (edge != null) {
					edge.setStatus(EnumOutputStatus.ROUTE);
					List<NodeOutput> list = this.getListNodeOutput(nodeRouteNextName);
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
		this.setStatus(EnumVisualizationStatus.FINISHED);
		this.stopAutomatic();		
	}
		
	@Override
	protected Boolean execute() {
		if (this.getStatus() == EnumVisualizationStatus.RUN) {
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
		this.updateViews();
		return true;
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
	public List<NodeOutput> getListNodeOutput(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			List<NodeOutput> list = mapNodesOutput.get(name);
			if (list == null) {
				list = new ArrayList<NodeOutput>();
			}
			return list; 		
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	@Override
	public List<String> getListNodeNames() {
		return new ArrayList<String>(listNodeNames);
	}

	@Override
	public Node getNode(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			return mapNodes.get(name);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Edge getEdge(String nameA, String nameB) {
		if ((nameA != null) && (nameB != null)) {
			Node nodeA = getNode(nameA);
			Node nodeB = getNode(nameB);
			if ((nodeA != null) && (nodeB != null)) {
				for (Edge edge : listEdges) {
					if (edge.isConnected(nodeA, nodeB)) {
						return edge;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public Integer getMaxTableLines() {
		return mapNodes.size();
	}
	
	@Override
	public List<String> getListNodeTargetNames() {
		return new ArrayList<String>(this.listNodeTargetNames);
	}

	@Override
	public List<String> getListNodeUsedNames() {
		return new ArrayList<String>(this.listNodeUsedNames);
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
	public void assume(String start, String target) {
		try {
			if ((start == null) || (target == null)) {
				throw new NullPointerException();
			}
			if (start.equals(target)) {
				throw new IllegalArgumentException();
			}			
			Node nodeStart = mapNodes.get(start);
			Node nodeTarget = mapNodes.get(target);
			nodeStart.setType(EnumNodeType.START);
			nodeTarget.setType(EnumNodeType.TARGET);
			this.updateListNodeTargetNames();
			this.setStatus(EnumVisualizationStatus.RUN);
			this.updateViews();
		} catch (Exception ex) {
			MessageBox.showErrorMessage("falscher Start, falsches Ziel");
		}		
	}

	@Override
	public Map<String, List<NodeOutput>> getMapNodesOutput() {
		return new HashMap<String, List<NodeOutput>>(this.mapNodesOutput);
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerDijkstraAlgorithmImpl.getInstance();
	}

	@Override
	public void changeWeight(EnumEdge edge, Integer weight) {
		// TODO Auto-generated method stub
		
	}
}