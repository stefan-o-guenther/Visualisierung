/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;



public class NodeOutputInfinityImpl extends OutputAbstract implements NodeOutputInfinity {

	public NodeOutputInfinityImpl() {
		super();
	}
	
	@Override
	public EnumNodeOutputType getNodeOutputType() {
		return EnumNodeOutputType.INFINITY;
	}

	@Override
	public String toString() {
		return Character.toString('\u221E');
	}
}
