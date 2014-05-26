package Rechnernetze.TCP_Fairness;

import java.awt.Color;

public class PointStartImpl extends PointAbstract implements PointStart {

	public PointStartImpl() {
		
	}
	
	@Override
	public Color getColor() {
		return Color.BLACK;
	}

	@Override
	public EnumPoint getType() {
		return EnumPoint.START;
	}
}
