/**
 * @author:	Stefan Otto G�nther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;

public interface NodeOutputNormal extends NodeOutputWeight {
	public String getPreviousNodeName();
	public void setPreviousNodeName(String value);
}
