/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.Color;

public class PointErrorImpl extends PointAbstract implements PointError {

	public PointErrorImpl() {
		
	}
	
	public PointErrorImpl(Integer connection1, Integer connection2) {
		super(connection1, connection2);
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
