package Rechnernetze.Dijkstra;

import java.awt.Color;

import Base.EnumSurface;

public class MinOutputNormal implements IMinOutputNormal {

	public MinOutputNormal() {
		name = "";
	}
	
	public MinOutputNormal(String value) {
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
