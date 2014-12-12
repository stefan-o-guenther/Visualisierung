/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;

import Base.Checker;
import Base.EnumSurface;

public class SpaceUsedImpl extends SpaceAbstract implements SpaceUsed {

	public SpaceUsedImpl(Integer value) {
		super(value);
	}

	@Override
	public EnumSpace getType() {
		return EnumSpace.USED;
	}

	@Override
	public Color getColorFont(EnumSurface surface) {
		try {
			Checker.checkIfNotNull(surface);
			return Color.BLACK;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Color getColorBox(EnumSurface surface) {
		try {
			Checker.checkIfNotNull(surface);
			Color color = null;
			switch (surface) {
				case COLORED: {
					color = new Color(135,206,250);
					break;
				}
				case GRAY: {
					color = Color.LIGHT_GRAY;
					break;
				}
				default: {
					throw new IllegalArgumentException();
				}
			}
			return color;
		} catch (Exception ex) {
			throw ex;
		}		
	}
}
