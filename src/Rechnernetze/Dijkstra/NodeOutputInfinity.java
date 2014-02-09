package Rechnernetze.Dijkstra;

import java.awt.Color;

public class NodeOutputInfinity extends BaseOutput implements INodeOutputInfinity {

	public NodeOutputInfinity() {
		super();
	}
	
	@Override
	public EnumNodeOutputType getNodeOutputType() {
		return EnumNodeOutputType.INFINITY;
	}

	@Override
	public String toString() {
		return Character.toString('\u221E');
	}
}
