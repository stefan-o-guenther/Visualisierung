package Rechnernetze.Dijkstra;

public interface INodeOutputWeight extends INodeOutput {
	Integer getWeightToAccess();
	void setWeightToAccess(Integer value);
}
