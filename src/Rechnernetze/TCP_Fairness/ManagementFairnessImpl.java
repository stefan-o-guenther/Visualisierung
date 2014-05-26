/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.CoordinateSystem;
import Base.CoordinateSystemImpl;
import Base.ManagementAutomaticAbstract;

public class ManagementFairnessImpl extends ManagementAutomaticAbstract implements ManagementFairness {

	public ManagementFairnessImpl() {
		super();
		
		initCoordinateSystem();
	}
	
	private CoordinateSystem cs;
	
	private EnumFairnessStatus status;
	
	private Integer connection1;
	private Integer connection2;
	private Integer maxFlowRate;
	
	private void initCoordinateSystem() {
		cs = new CoordinateSystemImpl(this);
		cs.setGapLeft(30);
		cs.setGapRight(10);
		cs.setGapTop(20);
		cs.setGapBottom(50);
		cs.setInterval(20);
		cs.setArrowLength(10);
	}
	
	@Override
	public Boolean execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	private void init() {
		this.connection1 = 0;
		this.connection2 = 0;
		this.maxFlowRate = 0;
	}

	@Override
	public String getTitle() {
		return "TCP-Fairness";
	}

	@Override
	public CoordinateSystem getCoordinateSystem() {
		return cs;
	}

	@Override
	public EnumFairnessStatus getFairnessStatus() {
		return status;
	}

	@Override
	public Integer getMaxFlowRate() {
		return this.maxFlowRate;
	}

	@Override
	public void setMaxFlowRate(Integer maxFlowRate) {
		try {
			if (maxFlowRate == null) {
				throw new NullPointerException();
			}
			if (maxFlowRate > getMaxConnnection()) {
				throw new IllegalArgumentException();
			}
			this.maxFlowRate = maxFlowRate;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getConnection1() {
		return this.connection1;
	}

	@Override
	public Integer getConnection2() {
		return this.connection2;
	}

	@Override
	public void setConnections(Integer connection1, Integer connection2) {
		try {
			if ((connection1 == null) || (connection2 == null)) {
				throw new NullPointerException();
			}			
			Integer sum = connection1 + connection2;
			if (sum > this.getMaxFlowRate()) {
				throw new IllegalArgumentException();
			}
			this.connection1 = connection1;
			this.connection2 = connection2;
			status = EnumFairnessStatus.RUN;
			this.updateAllPanels();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getMaxConnnection() {
		Integer maxX = cs.getXMax();
		Integer maxY = cs.getYMax();
		if (maxY > maxX) {
			return maxX;
		} else {
			return maxY;
		}
	}
}
