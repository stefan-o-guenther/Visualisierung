/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumCoordinateSystem;
import Base.EnumSurface;
import Base.EnumVisualizationStatus;
import Base.ManagementCoordinateSystemAbstract;
import Base.PanelAbstract;
import Base.PanelMenuControlBoxImpl;

public class ManagementFairnessImpl extends ManagementCoordinateSystemAbstract implements ManagementFairness {

	public ManagementFairnessImpl() {
		super();
	}
	
	private EnumVisualizationStatus status;	
	private List<Point> listPoints;
	private Integer maxFlowRate;

	@Override
	protected void initialize() {
		listPoints = new ArrayList<Point>();
		status = EnumVisualizationStatus.START;
		this.setMaxFlowRate();
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
	protected Boolean execute() {
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
						if (sum > this.getMaxFlowRate()) {
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
			this.updateAllPanels();
			return result;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public String getTitle() {
		return "TCP-Fairness";
	}

	@Override
	public EnumVisualizationStatus getStatus() {
		return status;
	}

	private void setMaxFlowRate() {
		int xMax = getXMax().intValue();
		int yMax = getYMax().intValue();
		Integer max = 0;
		if (yMax > xMax) {
			max = xMax;
		} else {
			max = yMax;
		}			
		this.maxFlowRate = max; 				
	}
	
	@Override
	public Integer getMaxFlowRate() {
		return this.maxFlowRate;
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
		Integer maxX = getXMax();
		Integer maxY = getYMax();
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

	@Override
	public String getModus() {
		if (status == EnumVisualizationStatus.START) {
			return "-";
		} else {
			return "Congestion Avoidance"; 
		}
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
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

	@Override
	protected void showErrorMessage() {
		
	}

	@Override
	protected void updateSize() {
		if ((status == EnumVisualizationStatus.START)) {
			int widthO = getWidth().intValue();
			int heightO = getHeight().intValue();
			int widthN = width.intValue();
			int heightN = height.intValue();
			if ((widthO != widthN) || (heightO != heightN)) {
				setHeight(height);
				setWidth(width);
			}
			if (this.getStatus() == EnumVisualizationStatus.START) {
				this.setMaxFlowRate();
			}
		}
		this.updateAllPanels();
	}

	@Override
	protected void create() {
		this.initCoordinateSystem();
	}
	
	@Override
	public Integer getGapBetweenX() {
		return 7;
	}
	
	@Override
	public Integer getGapBetweenY() {
		return 7;
	}
	
	@Override
	public Integer getIntervalX() {
		return 4;
	}
	
	@Override
	public Integer getIntervalY() {
		return 4;
	}

	@Override
	public Integer getArrowLength() {
		return 10;
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	public EnumCoordinateSystem getPosition() {
		return EnumCoordinateSystem.RIGHT;
	}

	@Override
	public Boolean isSameLength() {
		return true;
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
		return 30;
	}

	@Override
	public Integer getAutomaticSpace() {
		return 0;
	}

	@Override
	protected void createPanelMenu() {
		PanelAbstract panelLeft = new PanelRNTCPFairnessMenuImpl(this);
		PanelAbstract panelRight = new PanelMenuControlBoxImpl(this);
		this.panelMenu = this.getPanelCouple(panelLeft, panelRight);
	}

	@Override
	protected void createPanelModel() {
		this.panelModel = new PanelRNTCPFairnessModelImpl(this);		
	}

	@Override
	protected void createToolTipManager() {
		this.tooltip = new ToolTipManagerFairnessImpl();
	}
}
