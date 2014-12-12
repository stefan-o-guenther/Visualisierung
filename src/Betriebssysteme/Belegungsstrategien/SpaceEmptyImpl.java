/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;

import Base.Checker;
import Base.EnumSurface;

public class SpaceEmptyImpl extends SpaceAbstract implements SpaceEmpty {

	public SpaceEmptyImpl(Integer value) {
		super(value);
		this.isActivated = false;
		this.showNewValue = false;
		this.showRestValue = false;
		this.newValue = 0;	
	}

	private Boolean isActivated;
	private Boolean showRestValue;
	private Boolean showNewValue;
	private Integer newValue;	
	
	@Override
	public EnumSpace getType() {
		return EnumSpace.EMPTY;
	}
	
	@Override
	public Color getColorFont(EnumSurface surface) {
		try {
			Checker.checkIfNotNull(surface);
			if ((isActivated) && (surface == EnumSurface.COLORED)) {
				return Color.RED;
			} else {
				return Color.BLACK;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Color getColorBox(EnumSurface surface) {
		try {
			Checker.checkIfNotNull(surface);
			return Color.WHITE;
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	@Override
	public Boolean isActivated() {
		return isActivated;
	}

	@Override
	public void activate(Boolean value) {
		try {
			Checker.checkIfNotNull(value);
			isActivated = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Integer getNewValue() {
		return newValue;
	}

	@Override
	public void setNewValue(Integer value) {
		try {
			Checker.checkIfIntegerNotLessZero(value);
			newValue = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Integer getRestValue() {
		return (this.currentValue - this.newValue);
	}

	@Override
	public Boolean isRestValue() {
		return this.showRestValue;
	}

	@Override
	public void showRestValue(Boolean value) {
		try {
			Checker.checkIfNotNull(value);
			this.showRestValue = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Boolean isNewValue() {
		return this.showNewValue;
	}

	@Override
	public void showNewValue(Boolean value) {
		try {
			Checker.checkIfNotNull(value);
			this.showNewValue = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
