package Rechnernetze.Dijkstra;

public class NodeOutputMinus extends BaseOutput implements INodeOutputMinus {

	public NodeOutputMinus() {
		super();
	}
	
	@Override
	public EnumNodeOutputType getNodeOutputType() {
		return EnumNodeOutputType.MINUS;
	}

	@Override
	public String toString() {
		return "-";
	}
}
