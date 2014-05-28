/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

import Base.PanelModelDrawCoordinateSystemAbstract;

public class PanelRNTCPFairnessModelImpl extends PanelModelDrawCoordinateSystemAbstract {
	
	public PanelRNTCPFairnessModelImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
		this.initPanel();
	}
	
	private ManagementFairness fairness;
	
	private void printLines() {
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);
		List<Point> listPoints = fairness.getListPoints();
		Integer size = listPoints.size();
		for (Integer i = 1; i < size; i++) {
			Point point1 = listPoints.get(i-1);
			Point point2 = listPoints.get(i);
			Integer x1 = cs.XToPositionX(point1.getConnection1());
			Integer y1 = cs.YToPositionY(point1.getConnection2());
			Integer x2 = cs.XToPositionX(point2.getConnection1());
			Integer y2 = cs.YToPositionY(point2.getConnection2());
			g2d.drawLine(x1, y1, x2, y2);
		}
	}
	
	private void printMaxFlowRate() {
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);
		Integer mfr = fairness.getMaxFlowRate();
		Integer x1 = cs.XToPositionX(mfr);
		Integer y1 = cs.YToPositionY(0);
		Integer x2 = cs.XToPositionX(0);
		Integer y2 = cs.YToPositionY(mfr);
		g2d.setColor(fairness.getColorMaxFlowRate());
		g2d.drawLine(x1, y1, x2, y2);
	}
	
	private void printFairnessLine() {
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);
		Integer xMax = cs.getXMax();
		Integer yMax = cs.getYMax();
		Integer max = yMax;
		if (max > xMax) {
			max = xMax;
		}
		Integer x1 = cs.XToPositionX(0);
		Integer y1 = cs.YToPositionY(0);
		Integer x2 = cs.XToPositionX(max);
		Integer y2 = cs.YToPositionY(max);
		g2d.setColor(fairness.getColorFairness());
		g2d.drawLine(x1, y1, x2, y2);
	}
	
	private void printOvals() {
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);		
		List<Point> listPoints = fairness.getListPoints();
		for (Point point : listPoints) {
			if (point.getType() != EnumPoint.ROUTE) {
				Integer x = cs.XToPositionX(point.getConnection1());
				Integer y = cs.YToPositionY(point.getConnection2());
				g2d.setColor(point.getColor());
				g2d.fillOval(x-5, y-5, 10, 10);
			}			
		}		
	}
	
	@Override
	protected void doDrawing() {
		if (fairness != null) {
			fairness.setSize(this.getHeight(), this.getWidth());	
			this.printFairnessLine();			
			this.printMaxFlowRate();	
			this.printCoordinateSystem("Verbindung 1", "Verbindung 2");
			this.printLines();
			this.printOvals();
		}
		
	}

	@Override
	protected void initComponents() {
		this.fairness = (ManagementFairness) this.getManagement();
	}		
}
