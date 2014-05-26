package Rechnernetze.TCP_Fairness;

import java.awt.Color;

public class PointErrorImpl extends PointAbstract implements PointError {

	public PointErrorImpl() {
		
	}
	
	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public EnumPoint getType() {
		return EnumPoint.ERROR;
	}
}
