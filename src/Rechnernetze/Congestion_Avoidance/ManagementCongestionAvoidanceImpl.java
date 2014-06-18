/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.CoordinateSystem;
import Base.CoordinateSystemImpl;
import Base.EnumCoordinateSystem;
import Base.EnumVisualizationStatus;
import Base.ManagementAutomaticAbstract;

public class ManagementCongestionAvoidanceImpl extends ManagementAutomaticAbstract implements ManagementCongestionAvoidance {

	public ManagementCongestionAvoidanceImpl() {
		super();		
		init();
		initCoordinateSystem();
	}

	private CoordinateSystem cs;
	
	private Boolean reno;
	private Boolean tahoe;
	private EnumNetworkStrategy strategy = EnumNetworkStrategy.TIMEOUT;
	private Boolean start;
	
	private Integer maxTimeout;
	private Integer maxTrippleDuplACK;
	private Integer ssTreshTcpReno;
	private Integer ssTreshTcpTahoe;
	
	private List<Point> listPoints;	
	
	private void initCoordinateSystem() {
		cs = new CoordinateSystemImpl(false, EnumCoordinateSystem.BOTTOM);
		cs.setHeight(height);
		cs.setWidth(width);
		cs.setGapBetweenNumbers(20);
		cs.setInterval(1);
		cs.setArrowLength(10);
	}	
	
	private void init() {
		this.start = true;
		this.isAutomaticChecked = false;
		this.listPoints = new ArrayList<Point>();
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
	public Boolean execute() {
		try {
			if (((reno == true) || (tahoe == true)) && (this.getStatus() != EnumVisualizationStatus.FINISHED)) {
				if (start) {				
					Point firstPoint = new PointImpl(1,1, this.ssTreshTcpReno, this.ssTreshTcpTahoe);
					this.listPoints.add(firstPoint);
					start = false;
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
				updatePanelMain();
				return true;
			} else {
				setAutomaticChecked(false);
				setAutomaticRunning(false);
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		return false;
	}

	@Override
	public void reset() {
		init();
		updatePanelMain();
		
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
	public EnumVisualizationStatus getStatus() {
		if (start) {
			return EnumVisualizationStatus.START;
		} else {
			Integer max = this.getMaxTransmissionRound();
			Integer tr = this.getCurrentTransmissionRound();
			if (tr < max) {
				return EnumVisualizationStatus.RUN;
			} else {
				return EnumVisualizationStatus.FINISHED;
			}
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
		return cs.getXMax();
	}

	@Override
	public Integer getMaxCwnd() {
		return cs.getYMax();
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
	public CoordinateSystem getCoordinateSystem() {
		return this.cs;
	}

	@Override
	public Boolean isAutomaticEnabled() {
		return (this.getStatus() == EnumVisualizationStatus.RUN);
	}

	@Override
	public void showErrorMessage() {
		
	}

	@Override
	protected void updateSize() {
		if (cs != null) {
			int widthO = cs.getWidth().intValue();
			int heightO = cs.getHeight().intValue();
			int widthN = width.intValue();
			int heightN = height.intValue();
			if ((widthO != widthN) || (heightO != heightN)) {
				cs.setHeight(height);
				cs.setWidth(width);
			}
		}
		this.updatePanelMenu();
	}	
}