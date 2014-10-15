/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra_Algorithmus;



public class NodeOutputRouteImpl extends OutputAbstract implements NodeOutputRoute {

	public NodeOutputRouteImpl() {
		super();
		weight = 0;
		this.status = EnumOutputStatus.ROUTE;
	}
	
	public NodeOutputRouteImpl(Integer vWeight) {
		this();
		if (vWeight != null) {
			weight = vWeight;
		}
	}
	
	private Integer weight;
	
	@Override
	public EnumNodeOutputType getNodeOutputType() {
		return EnumNodeOutputType.ROUTE;
	}

	@Override
	public Integer getWeightToAccess() {
		return weight;
	}

	@Override
	public void setWeightToAccess(Integer value) {
		if (value != null) {
			weight = value;
		}
	}
	
	@Override
	public String toString() {
		return weight.toString();
	}
}
