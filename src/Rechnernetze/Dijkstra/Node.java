/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.EnumSurface;

public class Node implements INode {

	public Node(String value) {
		if (value == null) {
			value = "";
		}
		name = value;
		listEdges = new ArrayList<IEdge>();
		initialize();
	}	
	
	private List<IEdge> listEdges = null;
	private String name = null;
	private INode previousNode = null;
	private Boolean used = null;
	
	private INode getOtherNodeOfEdge(IEdge edge) {
		if (edge != null) {
			INode nodeA = edge.getNodeA();	
			INode nodeB = edge.getNodeB();
			if (nodeA == this) {
				return nodeB;				
			} else if (nodeB == this) {
				return nodeA;
			}
		}
		return null;
	}
	
	private IEdge getConnectedEdge(INode node) {
		if (node != null) {
			for (IEdge edge : listEdges) {
				if (edge.isConnected(this, node)) {
					return edge;
				}
			}
		}
		return null;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		if (value != null) {
			name = value;
		}
	}

	@Override
	public INode getPreviousNode() {
		return previousNode;
	}
	
	@Override
	public void setPreviousNode(INode node) {
		if (node != null) {
			previousNode = node;
		}
	}

	@Override
	public Integer getPreviousWeight() {
		if (previousNode != null) {
			Integer previousWeight = previousNode.getPreviousWeight();
			if (previousWeight < 0) {
				previousWeight = 0;
			}
			IEdge previousEdge = this.getConnectedEdge(previousNode);
			return previousEdge.getWeight() + previousWeight;
		} else {
			return -1;
		}		
	}
	
	@Override
	public Boolean hasPreviousNode() {
		return (previousNode != null);
	}
	
	@Override
	public Boolean isUsed() {
		return used;
	}

	@Override
	public void setUsed(Boolean value) {
		if (value != null) {
			used = value;
		}
	}

	@Override
	public IEdge getPreviousEdge() {
		if (previousNode != null) {
			for (IEdge edge : listEdges) {
				INode node = this.getOtherNodeOfEdge(edge);
				if (previousNode == node) {
					return edge;
				}
			}
		}
		return null;
	}

	@Override
	public List<INode> getRoute() {
		List<INode> list = null;
		if (this.hasPreviousNode()) {
			list = getPreviousNode().getRoute();
		} else {
			list = new ArrayList<INode>();
		}
		list.add(this);
		return list;
	}

	@Override
	public void addEdge(IEdge edge) {
		if (edge != null) {
			if (listEdges == null) {
				listEdges = new ArrayList<IEdge>();
			}
			if (this.isConnected(edge)) {
				listEdges.add(edge);
			}
		}
	}

	@Override
	public void execute(INode node) {
		if ((node != null) && (this.isConnected(node)) && (!(node.isUsed())) && (node != this)) {
			IEdge edge = this.getConnectedEdge(node);
			if (node.hasPreviousNode()) {
				Integer weightCurrent = node.getPreviousWeight();
				Integer weightNew = this.getPreviousWeight() + edge.getWeight();
				if (weightNew < weightCurrent) {
					node.setPreviousNode(this);				
				}
			} else {
				if (node.isConnected(edge)) {
					node.setPreviousNode(this);			
				}
			}
		}
	}

	@Override
	public Boolean isConnected(IEdge edge) {
		if (edge != null) {
			INode nodeA = edge.getNodeA();		
			INode nodeB = edge.getNodeB();
			if ((nodeA == this) || (nodeB == this)) {
				return true;
			}		
		}
		return false;
	}

	@Override
	public Boolean isConnected(INode node) {
		if (node != null) {
			for (IEdge edge : listEdges) {
				if (edge.isConnected(this, node)) {
					return true;
				}
			}
		}	
		return false;
	}

	@Override
	public void initialize() {
		previousNode = null;
		setUsed(false);
	}
	
	private Color getColoredColor() {
		if (used) {
			return Color.RED;
		} else {
			return Color.WHITE;
		}
	}
	
	private Color getGrayColor() {
		if (used) {
			return Color.LIGHT_GRAY;
		} else {
			return Color.WHITE;
		}
	}

	@Override
	public Color getColor(EnumSurface surface) {
		if (surface != null) {
			if (surface == EnumSurface.COLORED) {
				return getColoredColor();
			} else if (surface == EnumSurface.GRAY) {
				return getGrayColor();
			}
		}
		return Color.WHITE;
	}
}
