/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

public class NodeOutput implements INodeOutput {

	public NodeOutput() {
		name = "";
		weight = 0;
		type = EnumPreviousType.NORMAL;
	}
	
	String name;
	Integer weight;
	EnumPreviousType type;
	
	@Override
	public String getPreviousNodeName() {
		return name;
	}

	@Override
	public void setPreviousNodeName(String value) {
		if (value != null) {
			name = value;
		}
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
	public EnumPreviousType getPreviousNodeType() {
		return type;
	}

	@Override
	public void setPreviousNodeType(EnumPreviousType value) {
		if (value != null) {
			type = value;
		}
	}

}