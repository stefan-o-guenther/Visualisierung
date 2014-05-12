/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface NodeOutputWeight extends NodeOutput {
	public Integer getWeightToAccess();
	public void setWeightToAccess(Integer value);
}
