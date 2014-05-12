/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface NodeOutputNormal extends NodeOutputWeight {
	public String getPreviousNodeName();
	public void setPreviousNodeName(String value);
}
