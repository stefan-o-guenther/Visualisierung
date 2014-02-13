/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;


public class NodeOutputRoute extends BaseOutput implements INodeOutputRoute {

	public NodeOutputRoute() {
		super();
		weight = 0;
		this.status = EnumOutputStatus.ROUTE;
	}
	
	public NodeOutputRoute(Integer vWeight) {
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
