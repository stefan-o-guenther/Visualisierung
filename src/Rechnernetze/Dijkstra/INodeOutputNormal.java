/**
 * @author:	Stefan Otto G�nther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

public interface INodeOutputNormal extends INodeOutputWeight {
	String getPreviousNodeName();
	void setPreviousNodeName(String value);
}
