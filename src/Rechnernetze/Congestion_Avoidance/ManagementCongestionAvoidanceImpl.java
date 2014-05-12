/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.util.ArrayList;
import java.util.List;

import Base.ManagementAbstract;

public class ManagementCongestionAvoidanceImpl extends ManagementAbstract implements ManagementCongestionAvoidance {

	public ManagementCongestionAvoidanceImpl() {
		super();
		init();
	}

	private Boolean isAutomaticChecked;
	private EnumNetworkStrategy strategy = EnumNetworkStrategy.TIMEOUT;
	private EnumNetworkType type = EnumNetworkType.NONE;
	private EnumNetworkStatus status = EnumNetworkStatus.START;
	
	private Integer maxTimeout;
	private Integer maxTrippleDuplACK;
	private Integer ssTreshTcpReno;
	private Integer ssTreshTcpTahoe;
	private Integer maxX = 200;
	private List<Point> listPoints;
	
	private void init() {
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
			if ((type != EnumNetworkType.NONE) && (status != EnumNetworkStatus.FINISHED)) {
				if (status == EnumNetworkStatus.START) {					
					Point firstPoint = new PointImpl(1,1,1);
					this.listPoints.add(firstPoint);
					this.status = EnumNetworkStatus.RUN;
				} else {
					Integer size = this.listPoints.size();
					if (size > 0) {
						Point lastPoint = this.listPoints.get(size-1);
											
						Integer lastTR = lastPoint.getTransmissionRound();
						Integer lastCwndR = lastPoint.getCwndTcpReno();
						Integer lastCwndT = lastPoint.getCwndTcpTahoe();
						
						Integer newTR = lastTR + 1;
						
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
						Point newPoint = new PointImpl(newTR, newCwndR,newCwndT);
						listPoints.add(newPoint);
						
						if (newTR >= maxX) {
							this.status = EnumNetworkStatus.FINISHED;
						}
					}					
				}
				update();
				return true;
			} else {
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
	}

	@Override
	public Boolean isAutomaticChecked() {
		return false;
	}

	@Override
	public void setAutomaticChecked(Boolean value) {
		if (value != null) {
			this.isAutomaticChecked = value;
		}
	}

	@Override
	public Boolean isAutomaticRunning() {
		return this.isAutomaticChecked;
	}

	@Override
	public void setAutomaticRunning(Boolean value) {
		
	}

	@Override
	public Integer getSpeed() {
		return 0;
	}

	@Override
	public void setSpeed(Integer value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public EnumNetworkType getNetworkType() {
		return type;
	}

	@Override
	public void setNetworkType(EnumNetworkType type) {
		if (type != null) {
			this.type = type;
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
	public EnumNetworkStatus getNetworkStatus() {
		return status;
	}

	@Override
	public void setNetworkStatus(EnumNetworkStatus status) {
		if (status != null) {
			this.status = status;
		}
	}

	@Override
	public Integer getMaxTimeout() {
		return maxTimeout;
	}

	@Override
	public void setMaxTimeout(Integer max) {
		if (max != null) {
			this.maxTimeout = max;
		}
	}

	@Override
	public Integer getMaxTrippleDuplACK() {
		return maxTrippleDuplACK;
	}

	@Override
	public void setMaxTrippleDuplACK(Integer max) {
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
			System.out.println("ssTresh");
			this.ssTreshTcpReno = value;
			this.ssTreshTcpTahoe = value;
		}
	}

	@Override
	public Integer getMaxTransmissionRound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxTransmissionRound(Integer tr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getMaxCwnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxCwnd(Integer cwnd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		return "Congestion Avoidance";
	}	
}
