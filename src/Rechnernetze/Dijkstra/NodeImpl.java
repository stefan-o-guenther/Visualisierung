/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.EnumSurface;

public class NodeImpl implements Node {

	public NodeImpl(String name, Integer x, Integer y) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = "";
		}
		if (x != null) {
			this.x = x;
		} else {
			this.x = 0;
		}
		if (y != null) {
			this.y = y;
		} else {
			this.y = 0;
		}
		listEdges = new ArrayList<Edge>();
		initialize();
	}	
	
	private List<Edge> listEdges = null;
	private String name = null;
	private Node previousNode = null;
	private Boolean used = null;
	
	private Integer x;
	private Integer y;
	
	private Node getOtherNodeOfEdge(Edge edge) {
		if (edge != null) {
			Node nodeA = edge.getNodeA();	
			Node nodeB = edge.getNodeB();
			if (nodeA == this) {
				return nodeB;				
			} else if (nodeB == this) {
				return nodeA;
			}
		}
		return null;
	}
	
	private Edge getConnectedEdge(Node node) {
		if (node != null) {
			for (Edge edge : listEdges) {
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
	public Node getPreviousNode() {
		return previousNode;
	}
	
	@Override
	public void setPreviousNode(Node node) {
		if ((node != null) && (isConnected(node))) {
			previousNode = node;
		}
	}

	@Override
	public void deletePreviousNode() {
		previousNode = null;
	}

	@Override
	public Integer getPreviousWeight() {
		if (previousNode != null) {
			Integer previousWeight = previousNode.getPreviousWeight();
			if (previousWeight < 0) {
				previousWeight = 0;
			}
			Edge previousEdge = this.getConnectedEdge(previousNode);
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
	public Edge getPreviousEdge() {
		if (previousNode != null) {
			for (Edge edge : listEdges) {
				Node node = this.getOtherNodeOfEdge(edge);
				if (previousNode == node) {
					return edge;
				}
			}
		}
		return null;
	}

	@Override
	public List<Node> getRoute() {
		List<Node> list = null;
		if (this.hasPreviousNode()) {
			list = getPreviousNode().getRoute();
		} else {
			list = new ArrayList<Node>();
		}
		list.add(this);
		return list;
	}

	@Override
	public void addEdge(Edge edge) {
		if (edge != null) {
			if (listEdges == null) {
				listEdges = new ArrayList<Edge>();
			}
			if (this.isConnected(edge)) {
				listEdges.add(edge);
			}
		}
	}

	@Override
	public Boolean isConnected(Edge edge) {
		if (edge != null) {
			Node nodeA = edge.getNodeA();		
			Node nodeB = edge.getNodeB();
			if ((nodeA == this) || (nodeB == this)) {
				return true;
			}		
		}
		return false;
	}

	@Override
	public Boolean isConnected(Node node) {
		if (node != null) {
			for (Edge edge : listEdges) {
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

	@Override
	public Integer getX() {
		return x;
	}

	@Override
	public void setX(Integer x) {
		if (x != null) {
			this.x = x;
		}
	}

	@Override
	public Integer getY() {
		return y;
	}

	@Override
	public void setY(Integer y) {
		if (y != null) {
			this.y = y;
		}
	}
}
