package Rechnernetze.TCP_Fairness;

import java.awt.Color;

public class PointRouteImpl extends PointAbstract implements PointRoute {

	public PointRouteImpl() {
		
	}
	
	@Override
	public Color getColor() {
		return Color.WHITE;
	}

	@Override
	public EnumPoint getType() {
		return EnumPoint.ROUTE;
	}
}
