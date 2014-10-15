/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;



public class EdgeImpl extends OutputAbstract implements Edge {

	public EdgeImpl(Node a, Node b, Integer value) {
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
	
	private Node nodeA;
	private Node nodeB;
	private Integer weight;
	//private EnumOutputStatus status = EnumOutputStatus.NORMAL;
	
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
	public Node getNodeA() {
		return nodeA;
	}

	@Override
	public void setNodeA(Node value) {
		if (value != null) {
			nodeA = value;
		}
	}

	@Override
	public Node getNodeB() {
		return nodeB;
	}

	@Override
	public void setNodeB(Node value) {
		if (value != null) {
			nodeB = value;
		}
	}

	@Override
	public Boolean isConnected(Node node) {
		if ((node != null) && ((node == nodeA) || (node == nodeB))) {		
			return true;			
		} else {
			return false;
		}		
	}

	@Override
	public Boolean isConnected(Node node1, Node node2) {
		if (((node1 != null) && (node2 != null)) && (((node1 == nodeA) && (node2 == nodeB)) || ((node1 == nodeB) && (node2 == nodeA)))) {
			return true;
		} else {
			return false;
		}
	}
}
