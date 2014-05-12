/**
 * @author:	Stefan Otto Günther
 * @date:	08.02.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.Color;

import Base.EnumSurface;

public class MinOutputNormalImpl implements MinOutputNormal {

	public MinOutputNormalImpl() {
		name = "";
	}
	
	public MinOutputNormalImpl(String value) {
		this();
		if (value != null) {
			name = value;
		}
	}
	
	private String name;
	
	@Override
	public EnumMinOutputType getType() {
		return EnumMinOutputType.NORMAL;
	}

	@Override
	public Color getColor(EnumSurface surface) {
		return Color.BLACK;
	}

	@Override
	public String getNodeName() {
		return name;
	}

	@Override
	public void setNodeName(String value) {
		if (value != null) {
			name = value;
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
