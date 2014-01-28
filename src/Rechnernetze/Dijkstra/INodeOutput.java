/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

public interface INodeOutput {

	String getPreviousNodeName();
	void setPreviousNodeName(String value);
	
	Integer getWeightToAccess();
	void setWeightToAccess(Integer value);
	
	EnumPreviousType getPreviousNodeType();
	void setPreviousNodeType(EnumPreviousType value);
}
