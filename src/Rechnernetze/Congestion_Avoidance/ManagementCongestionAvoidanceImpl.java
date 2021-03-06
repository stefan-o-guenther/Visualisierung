/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumCoordinateSystem;
import Base.EnumVisualizationStatus;
import Base.ManagementCoordinateSystemAbstract;
import Base.ToolTipManager;

public class ManagementCongestionAvoidanceImpl extends ManagementCoordinateSystemAbstract implements ManagementCongestionAvoidance {

    public ManagementCongestionAvoidanceImpl() {
    	super();
    }

	private Boolean reno;
	private Boolean tahoe;
	private EnumNetworkStrategy strategy = EnumNetworkStrategy.TIMEOUT;
	
	private Integer maxTimeout;
	private Integer maxTrippleDuplACK;
	private Integer ssTreshTcpReno;
	private Integer ssTreshTcpTahoe;
	
	private List<Point> listPoints;	
	
	@Override
	protected void initialize() {
		this.listPoints = new ArrayList<Point>();
		initCoordinateSystem();
	}
	
	private Integer increaseCwnd(Integer oldCwnd, Integer ssTresh) {
		Integer newCwnd;
		if (oldCwnd < ssTresh) {
			newCwnd = oldCwnd * 2;
			if (newCwnd > ssTresh) {
				newCwnd = ssTresh;
			}
		} else {
			newCwnd = oldCwnd + 1;
		}
		return newCwnd;
	}
	
	private Integer getNewSsTresh(Integer ssTresh, Integer cwnd) {
		Integer max = getMax();
		if (cwnd > max) {
			ssTresh = max / 2;
			if (ssTresh < 1) {
				ssTresh = 1;
			}
		} 
		return ssTresh;
	}
	
	private Integer timoutCwnd(Integer cwnd) {
		if (cwnd > this.maxTimeout) {
			cwnd = 1;
		}
		return cwnd;
	}
	
	private Integer trippleDuplAckCwnd(Integer cwnd, Boolean isReno) {
		if (cwnd > this.maxTrippleDuplACK) {
			if (isReno) {
				cwnd = this.ssTreshTcpReno;
			} else {
				cwnd = 1;
			}
		}
		return cwnd;
	}
	
	private Integer getMax() {
		Integer result = 1;
		switch (strategy) {
			case TIMEOUT: {
				result = this.maxTimeout;
				break;
			}
			case TRIPPLE_DUBL_ACK: {
				result = this.maxTrippleDuplACK;
				break;
			}
		}
		return result;
	}

	@Override
	protected Boolean execute() {
		try {
			if (((reno == true) || (tahoe == true)) && (this.getStatus() != EnumVisualizationStatus.FINISHED)) {
				if (this.getStatus() == EnumVisualizationStatus.START) {				
					Point firstPoint = new PointImpl(1,1, this.ssTreshTcpReno, this.ssTreshTcpTahoe);
					this.listPoints.add(firstPoint);
					this.setStatus(EnumVisualizationStatus.RUN);
				} else {
					Integer size = this.listPoints.size();
					if (size > 0) {
						Point lastPoint = this.listPoints.get(size-1);
											
						Integer lastCwndR = lastPoint.getCwndTcpReno();
						Integer lastCwndT = lastPoint.getCwndTcpTahoe();
						
						Integer newCwndR = this.increaseCwnd(lastCwndR, ssTreshTcpReno);
						Integer newCwndT = this.increaseCwnd(lastCwndT, ssTreshTcpTahoe);
												
						this.ssTreshTcpReno = this.getNewSsTresh(ssTreshTcpReno, newCwndR);
						this.ssTreshTcpTahoe  = this.getNewSsTresh(ssTreshTcpTahoe, newCwndT);
												
						switch (strategy) {
							case TIMEOUT: {
								newCwndR = this.timoutCwnd(newCwndR);
								newCwndT = this.timoutCwnd(newCwndT);
								break;
							}
							case TRIPPLE_DUBL_ACK: {
								newCwndR = this.trippleDuplAckCwnd(newCwndR, true);
								newCwndT = this.trippleDuplAckCwnd(newCwndT, false);
								break;
							}
						}						
						Point newPoint = new PointImpl(newCwndR, newCwndT, this.ssTreshTcpReno, this.ssTreshTcpTahoe);
						listPoints.add(newPoint);
					}					
				}
				this.checkTransmissionRound();
				this.updateViews();
				return true;
			} else {
				this.stopAutomatic();
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		return false;
	}

	@Override
	protected void updateSize() {
		this.checkTransmissionRound();
	}
	
	private void checkTransmissionRound() {
		if (this.getStatus() != EnumVisualizationStatus.START) {
			Integer max = this.getMaxTransmissionRound();
			Integer tr = this.getCurrentTransmissionRound();
			if (tr < max) {
				this.setStatus(EnumVisualizationStatus.RUN);
			} else {
				this.setStatus(EnumVisualizationStatus.FINISHED);
			}
		}
	}

	@Override
	public EnumNetworkStrategy getNetworkStrategy() {
		return strategy;
	}

	@Override
	public void setNetworkStrategy(EnumNetworkStrategy strategy) {
		if (strategy != null) {
			this.strategy = strategy;
		}
	}

	@Override
	public Integer getTimeout() {
		return maxTimeout;
	}

	@Override
	public void setTimeout(Integer max) {
		if (max != null) {
			this.maxTimeout = max;
		}
	}

	@Override
	public Integer getTrippleDuplACK() {
		return maxTrippleDuplACK;
	}

	@Override
	public void setTrippleDuplACK(Integer max) {
		if (max != null) {
			this.maxTrippleDuplACK = max;
		}
	}

	@Override
	public List<Point> getListPoints() {
		return new ArrayList<Point>(this.listPoints);
	}

	@Override
	public void setSsTresh(Integer value) {
		if (value != null) {
			this.ssTreshTcpReno = value;
			this.ssTreshTcpTahoe = value;
		}
	}

	@Override
	public Integer getMaxTransmissionRound() {
		return getXMax();
	}

	@Override
	public Integer getMaxCwnd() {
		return getYMax();
	}

	@Override
	public String getTitle() {
		return "Congestion Avoidance";
	}

	@Override
	public Boolean isTcpReno() {
		return this.reno;
	}

	@Override
	public void setTcpReno(Boolean reno) {
		if (reno != null) {
			this.reno = reno;
		}
	}

	@Override
	public Boolean isTcpTahoe() {
		return this.tahoe;
	}

	@Override
	public void setTcpTahoe(Boolean tahoe) {
		if (tahoe != null) {
			this.tahoe = tahoe;
		}
	}

	@Override
	public Integer getCurrentTransmissionRound() {
		return this.listPoints.size();
	}

	@Override
	public Color getColorTcpTahoe() {
		Color color = null;
		switch (surface) {
			case COLORED: {
				color = Color.BLUE;
				break;
			}
			case GRAY: {
				color = Color.DARK_GRAY;
				break;
			}
		}
		return color;
		
	}

	@Override
	public Color getColorTcpReno() {
		return Color.BLACK;
	}

	@Override
	public Color getColorSsTreshTcpTahoe() {
		Color color = null;
		switch (surface) {
			case COLORED: {
				color = Color.RED;
				break;
			}
			case GRAY: {
				color = Color.LIGHT_GRAY;
				break;
			}
		}
		return color;
	}

	@Override
	public Color getColorSsTreshTcpReno() {
		Color color = null;
		switch (surface) {
			case COLORED: {
				color = Color.GREEN;
				break;
			}
			case GRAY: {
				color = Color.GRAY;
				break;
			}
		}
		return color;
	}

	@Override
	protected void showErrorMessage() {
		
	}

	@Override
	protected void create() {
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	public Integer getArrowLength() {
		return 10;
	}

	@Override
	public EnumCoordinateSystem getPosition() {
		return EnumCoordinateSystem.BOTTOM;
	}

	@Override
	public Integer getGapBetweenX() {
		return 20;
	}

	@Override
	public Integer getGapBetweenY() {
		return 20;
	}

	@Override
	public Integer getIntervalX() {
		return 1;
	}

	@Override
	public Integer getIntervalY() {
		return 1;
	}

	@Override
	public Boolean isSameLength() {
		return false;
	}

	@Override
	protected Integer getGapLeft() {
		return 35;
	}

	@Override
	protected Integer getGapRight() {
		return 10;
	}

	@Override
	protected Integer getGapTop() {
		return 20;
	}

	@Override
	protected Integer getGapBottom() {
		return 50;
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerCongestionAvoidanceImpl.getInstance();
	}
}