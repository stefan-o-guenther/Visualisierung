/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;

import Base.EnumSurface;

public interface Space {
	
	public EnumSpace getType();
	
	public Integer getCurrentValue();
	public void setCurrentValue(Integer value);
	
	public Color getColorFont(EnumSurface surface);
	public Color getColorBox(EnumSurface surface);
}
