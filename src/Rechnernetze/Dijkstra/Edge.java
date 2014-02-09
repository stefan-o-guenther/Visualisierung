/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;


public class Edge extends BaseOutput implements IEdge {

	public Edge(INode a, INode b, Integer value) {
		super();
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
	
	private INode nodeA;
	private INode nodeB;
	private Integer weight;
	private EnumOutputStatus status = EnumOutputStatus.NORMAL;
	
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
}
