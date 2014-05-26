package Rechnernetze.TCP_Fairness;

import java.awt.Color;

public interface Point {

	public Integer getConnection1();
	public void setConnection1(Integer connection1);
	
	public Integer getConnection2();
	public void setConnection2(Integer connection2);
	
	public Color getColor();
	public EnumPoint getType();
}
