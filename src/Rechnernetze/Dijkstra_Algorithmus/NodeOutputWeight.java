/**
 * @author:	Stefan Otto G�nther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;

public interface NodeOutputWeight extends NodeOutput {
	public Integer getWeightToAccess();
	public void setWeightToAccess(Integer value);
}
