/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.CoordinateSystem;
import Base.CoordinateSystemImpl;
import Base.EnumSurface;
import Base.EnumVisualizationStatus;
import Base.ManagementAutomaticAbstract;

public class ManagementFairnessImpl extends ManagementAutomaticAbstract implements ManagementFairness {

	public ManagementFairnessImpl() {
		super();		
		initCoordinateSystem();
		init();
	}
	
	private CoordinateSystem cs;	
	private EnumVisualizationStatus status;	
	private Integer maxFlowRate;
	private List<Point> listPoints;
	
	private void init() {
		this.maxFlowRate = 0;
		listPoints = new ArrayList<Point>();
		status = EnumVisualizationStatus.START;
	}	
	
	private void initCoordinateSystem() {
		cs = new CoordinateSystemImpl(this);
		cs.setGapLeft(30);
		cs.setGapRight(10);
		cs.setGapTop(20);
		cs.setGapBottom(50);
		cs.setGapBetweenNumbers(7);
		cs.setInterval(4);
		cs.setArrowLength(10);
	}
	
	private void testListPoints() {
		try {
			if (listPoints != null) {
				Integer size = listPoints.size();
				if (size > 0) {
					Point point = listPoints.get(size-1);
					Integer c1 = point.getConnection1();
					Integer c2 = point.getConnection2();
					if (c1.equals(c2)) {
						if (point.getType() == EnumPoint.START) {
							status = EnumVisualizationStatus.FINISHED;
						} else {
							throw new IllegalArgumentException();
						}						
					} else {
						status = EnumVisualizationStatus.RUN;
					}
				}			
			}			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	
	
	@Override
	public Boolean execute() {
		try {
			Boolean result = true;
			if (listPoints != null) {
				Integer size = listPoints.size();
				if (size > 0) {
					if (status == EnumVisualizationStatus.RUN) {					
						Point point = listPoints.get(size-1);
						Integer c1 = point.getConnection1();
						Integer c2 = point.getConnection2();
						Integer sum = c1 + c2;
						if (sum > this.maxFlowRate) {
							PointError pointE = new PointErrorImpl(c1,c2);
							PointStart pointS = new PointStartImpl((c1/2), (c2/2));
							listPoints.remove(point);							
							listPoints.add(pointE);
							listPoints.add(pointS);
						} else {
							if (point.getType() == EnumPoint.ERROR) {
								throw new IllegalArgumentException();
							}
							if (point.getType() == EnumPoint.START) {
								PointRoute pointR = new PointRouteImpl(c1+1,c2+1);
								listPoints.add(pointR);
							} else {
								point.setConnection1(c1+1);
								point.setConnection2(c2+1);
							}
						}
					}
					this.testListPoints();
					if (status == EnumVisualizationStatus.FINISHED) {
						result = false;
					}
				} else {
					result = false;
				}
			} else {
				result = false;
			}
			this.update();
			return result;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void reset() {
		init();
		this.update();
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
	public EnumVisualizationStatus getFairnessStatus() {
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
	public void setConnections(Integer connection1, Integer connection2) {
		try {
			if ((connection1 == null) || (connection2 == null)) {
				throw new NullPointerException();
			}			
			Integer sum = connection1 + connection2;
			if (sum > this.getMaxFlowRate()) {
				throw new IllegalArgumentException();
			}
			PointStart point = new PointStartImpl(connection1, connection2);
			listPoints = new ArrayList<Point>();			
			listPoints.add(point);
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

	@Override
	public Integer getConnection1() {
		if (this.listPoints == null) {
			return 0;
		}
		Integer size = this.listPoints.size();
		if (size.equals(0)) {
			return 0;
		}
		Point point = listPoints.get(size-1);
		return point.getConnection1();
	}

	@Override
	public Integer getConnection2() {
		if (this.listPoints == null) {
			return 0;
		}
		Integer size = this.listPoints.size();
		if (size.equals(0)) {
			return 0;
		}
		Point point = listPoints.get(size-1);
		return point.getConnection2();
	}

	private String getModus() {
		if (status == EnumVisualizationStatus.START) {
			return "-";
		} else {
			return "Congestion Avoidance"; 
		}
	}
	
	
	@Override
	public String getModus1() {
		return this.getModus();
	}

	@Override
	public String getModus2() {
		return this.getModus();
	}

	@Override
	public Integer getDifference() {
		Integer dif = 0;
		Integer c1 = this.getConnection1();
		Integer c2 = this.getConnection2();		
		if (c1 > c2) {
			dif = c1 - c2;
		} else {
			dif = c2 - c1;
		}
		return dif;
	}

	@Override
	public List<Point> getListPoints() {
		if (listPoints != null) {
			return new ArrayList<Point>(this.listPoints);
		} else {
			return new ArrayList<Point>();
		}		
	}

	@Override
	public Color getColorFairness() {
		if (this.getSurface() == EnumSurface.COLORED) {
			return Color.BLUE;
		} else {
			return Color.BLACK;
		}
	}

	@Override
	public Color getColorMaxFlowRate() {
		if (this.getSurface() == EnumSurface.COLORED) {
			return Color.BLUE;
		} else {
			return Color.BLACK;
		}
	}
}
