package Rechnernetze.Dijkstra;

public class Edge implements IEdge {

	private INode nodeFrom;
	private INode nodeTo;
	private Integer weight;
	
	public Edge(INode from, INode to, Integer value) {
		nodeFrom = from;
		nodeTo = to;
		if (value == null) {
			value = 0;
		}
		weight = value;
	}
	
	@Override
	public INode getNodeFrom() {
		return nodeFrom;
	}

	@Override
	public void setNodeFrom(INode value) {
		if (value != null) {
			nodeFrom = value;
		}
	}

	@Override
	public INode getNodeTo() {
		return nodeTo;
	}

	@Override
	public void setNodeTo(INode value) {
		if (value != null) {
			nodeTo = value;
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
}
