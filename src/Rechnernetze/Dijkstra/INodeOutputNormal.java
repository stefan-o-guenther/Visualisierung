package Rechnernetze.Dijkstra;

public interface INodeOutputNormal extends INodeOutputWeight {
	String getPreviousNodeName();
	void setPreviousNodeName(String value);
}
