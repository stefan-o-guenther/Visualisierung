/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.Color;
import Base.EnumSurface;

public class Edge implements IEdge {

	private INode nodeA;
	private INode nodeB;
	private Integer weight;
	private EnumEdgeStatus status = EnumEdgeStatus.NORMAL;
	
	public Edge(INode a, INode b, Integer value) {
		nodeA = a;
		nodeB = b;
		if (value == null) {
			value = 0;
		}
		weight = value;
		if ((nodeA != null) && (nodeB != null)) {
			nodeA.addEdge(this);
			nodeB.addEdge(this);
		}
	}
	
	@Override
	public Integer getWeight() {
		return weight;
	}

	@Override
	public void setWeight(Integer value) {
		if (value != null) {
			weight = value;
		}
	}

	@Override
	public INode getNodeA() {
		return nodeA;
	}

	@Override
	public void setNodeA(INode value) {
		if (value != null) {
			nodeA = value;
		}
	}

	@Override
	public INode getNodeB() {
		return nodeB;
	}

	@Override
	public void setNodeB(INode value) {
		if (value != null) {
			nodeB = value;
		}
	}

	@Override
	public Boolean isConnected(INode node) {
		if ((node != null) && ((node == nodeA) || (node == nodeB))) {		
			return true;			
		} else {
			return false;
		}		
	}

	@Override
	public Boolean isConnected(INode node1, INode node2) {
		if (((node1 != null) && (node2 != null)) && (((node1 == nodeA) && (node2 == nodeB)) || ((node1 == nodeB) && (node2 == nodeA)))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EnumEdgeStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(EnumEdgeStatus value) {
		if (value != null) {
			status = value;
		}
	}

	private Color getColoredColor() {
		if (status == EnumEdgeStatus.ACTIVATED) {
			return Color.BLUE;
		} else if (status == EnumEdgeStatus.ROUTE) {
			return new Color(50,205,50);
		} else if (status == EnumEdgeStatus.NORMAL) {
			return Color.BLACK;
		} else {
			return Color.BLACK;
		}
	}
	
	private Color getGrayColor() {
		if (status == EnumEdgeStatus.ACTIVATED) {
			return Color.LIGHT_GRAY;
		} else if (status == EnumEdgeStatus.ROUTE) {
			return Color.GRAY;
		} else if (status == EnumEdgeStatus.NORMAL) {
			return Color.BLACK;
		} else {
			return Color.BLACK;
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
		return Color.BLACK;
	}
}
