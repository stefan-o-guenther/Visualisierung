package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;

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
			if (surface == null) {
				throw new NullPointerException();
			}
			return Color.BLACK;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Color getColorBox(EnumSurface surface) {
		try {
			if (surface == null) {
				throw new NullPointerException();
			} else if (surface == EnumSurface.COLORED) {
				return new Color(135,206,250);
			} else if (surface == EnumSurface.GRAY) {
				return Color.LIGHT_GRAY;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception ex) {
			throw ex;
		}		
		
	}
}
