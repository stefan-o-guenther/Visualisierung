/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;


public class NodeOutputInfinity extends BaseOutput implements INodeOutputInfinity {

	public NodeOutputInfinity() {
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
