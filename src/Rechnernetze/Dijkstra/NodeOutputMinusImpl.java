/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;


public class NodeOutputMinusImpl extends OutputAbstract implements NodeOutputMinus {

	public NodeOutputMinusImpl() {
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
