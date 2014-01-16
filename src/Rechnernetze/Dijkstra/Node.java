package Rechnernetze.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Node implements INode {

	private List<IEdge> listEdges;
	private EnumNodeType type;
	private String name;
	private IEdge previousEdge;
	
	
	public Node(String value) {
		if (value == null) {
			value = "";
		}
		name = value;
		listEdges = new ArrayList<IEdge>();
		type = EnumNodeType.NODE;
		previousEdge = null;
	}
	
	@Override
	public EnumNodeType getType() {
		return type;
	}

	@Override
	public void setType(EnumNodeType value) {
		if (value != null) {
			type = value;
		}
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
	public List<IEdge> getListEdges() {
		return listEdges;
	}

	@Override
	public void setListEdges(List<IEdge> value) {
		if (value != null) {
			listEdges = value;
		}
	}

	@Override
	public IEdge getPreviousEdge() {
		return previousEdge;
	}

	@Override
	public void setPreviousEdge(IEdge value) {
		if (value != null) {
			previousEdge = value;
		}
	}

	@Override
	public INode getPreviousNode() {
		INode node = null;
		if (previousEdge != null) {
			node = previousEdge.getNodeFrom();
		}
		return node;
	}

	@Override
	public Integer getPreviousWeight() {
		Integer weight = 0;
		IEdge edge = previousEdge;
		while(edge != null) {			
			weight += edge.getWeight();						
			INode node = edge.getNodeFrom();
			edge = node.getPreviousEdge();			
		}
		return weight;
	}

	@Override
	public void addEdge(IEdge value) {
		if (value != null) {
			if (listEdges == null) {
				listEdges = new ArrayList<IEdge>();
			}
			listEdges.add(value);
		}
	}
}
