/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

import Base.PanelModelDrawCoordinateSystemAbstract;

public class PanelRNCongestionAvoidanceModelImpl extends PanelModelDrawCoordinateSystemAbstract {

	public PanelRNCongestionAvoidanceModelImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.initPanel();
	}

	private ManagementCongestionAvoidance network;
	
	private void printOvals() {	
		if (cs != null) {
			BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);		
			
			List<Point> listPoints = network.getListPoints();
			Integer size = listPoints.size();		
			for (Integer i = 0; i < size; i++) {
				Point point = listPoints.get(i);
				Integer x = cs.XToPositionX(i+1);
				if (network.isTcpTahoe()) {	
					Integer y = cs.YToPositionY(point.getCwndTcpTahoe());
					g2d.setColor(network.getColorTcpTahoe());				
					g2d.fillOval(x-5, y-5, 10, 10);
				}
				if (network.isTcpReno()) {
					Integer y = cs.YToPositionY(point.getCwndTcpReno());
					g2d.setColor(network.getColorTcpReno());					
					g2d.fillOval(x-5, y-5, 10, 10);
				}
			}
		}		
	}
	
	private void printLines() {
		if (cs != null) {
			BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);	
			
			List<Point> listPoints = network.getListPoints();
			Integer size = listPoints.size();				
			for (Integer i = 1; i < size; i++) {
				Point pointA = listPoints.get(i-1);
				Point pointB = listPoints.get(i);
				Integer xA = cs.XToPositionX(i);
				Integer xB = cs.XToPositionX(i+1);			
				
				if (network.isTcpTahoe()) {								
					g2d.setColor(Color.CYAN);
					Integer yA = cs.YToPositionY(pointA.getCwndTcpTahoe());
					Integer yB = cs.YToPositionY(pointB.getCwndTcpTahoe());
					g2d.setColor(network.getColorTcpTahoe());
					g2d.drawLine(xA, yA, xB, yB);
				}			
				if (network.isTcpReno()) {													
					g2d.setColor(Color.GRAY);
					Integer yA = cs.YToPositionY(pointA.getCwndTcpReno());
					Integer yB = cs.YToPositionY(pointB.getCwndTcpReno());
					g2d.setColor(network.getColorTcpReno());
					g2d.drawLine(xA, yA, xB, yB);	
				}
			}			
		}		
	}
	
	private void printSsTreshs() {
		if (cs != null) {
			BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);	
			
			Integer gap = cs.getGapBetweenX();
			
			List<Point> listPoints = network.getListPoints();
			Integer size = listPoints.size();				
			for (Integer i = 0; i < size; i++) {
				Point point = listPoints.get(i);
				Integer tr1 = i;
				Integer tr2 = i + 1;
				if (i.equals((size-1))) {
					//tr2 = network.getMaxTransmissionRound();
				}
				Integer ssTreshT = point.getSsTreshTcpTahoe();
				Integer ssTreshR = point.getSsTreshTcpReno();
				//System.out.println(tr1 + ", " + tr2 + ", " + ssTreshT + ", " + ssTreshR);
				for (Integer x = tr1; x < tr2; x++) {
					//System.out.println(x);
					if (network.isTcpTahoe()) {
						Integer x1 = cs.XToPositionX(x) + 3;
						Integer x2 = cs.XToPositionX(x+1) - (gap / 2);
						Integer y = cs.YToPositionY(ssTreshT);
						g2d.setColor(network.getColorSsTreshTcpTahoe());
						g2d.drawLine(x1, y, x2, y);		
					}
					if (network.isTcpReno()) {
						Integer x1 = cs.XToPositionX(x) + (gap / 2) + 3;
						Integer x2 = cs.XToPositionX(x+1);
						Integer y = cs.YToPositionY(ssTreshR);
						g2d.setColor(network.getColorSsTreshTcpReno());
						g2d.drawLine(x1, y, x2, y);	
					}
				}
			}		
		}		
	}	
	
	@Override
	protected void doDrawing() {
		if (network != null) {
			network.setSize(this.getHeight(), this.getWidth());		
			printCoordinateSystem("Übertragungsrunden", "cwnd (in Segmenten)");			
			printSsTreshs();
			printLines();
			printOvals();
		}		
	}

	@Override
	protected void initComponents() {
		this.network = (ManagementCongestionAvoidance) this.getManagement();
	}
}