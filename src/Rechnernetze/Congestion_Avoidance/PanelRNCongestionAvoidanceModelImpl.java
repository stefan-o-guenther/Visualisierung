/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

import Base.ManagementFactory;
import Base.PanelDrawingCoordinateSystemAbstract;

public class PanelRNCongestionAvoidanceModelImpl extends PanelDrawingCoordinateSystemAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNCongestionAvoidanceModelImpl() {
		super(ManagementFactory.getManagementCongestionAvoidance());
		this.createPanel();
	}

	private ManagementCongestionAvoidance network;
	
	private void printOvals() {		
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);		
		
		List<Point> listPoints = network.getListPoints();
		Integer size = listPoints.size();		
		for (Integer i = 0; i < size; i++) {
			Point point = listPoints.get(i);
			Integer x = network.XToPositionX(i+1);
			if (network.isTcpTahoe()) {	
				Integer y = network.YToPositionY(point.getCwndTcpTahoe());
				g2d.setColor(network.getColorTcpTahoe());				
				g2d.fillOval(x-5, y-5, 10, 10);
			}
			if (network.isTcpReno()) {
				Integer y = network.YToPositionY(point.getCwndTcpReno());
				g2d.setColor(network.getColorTcpReno());					
				g2d.fillOval(x-5, y-5, 10, 10);
			}
		}				
	}
	
	private void printLines() {		
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);	
		
		List<Point> listPoints = network.getListPoints();
		Integer size = listPoints.size();				
		for (Integer i = 1; i < size; i++) {
			Point pointA = listPoints.get(i-1);
			Point pointB = listPoints.get(i);
			Integer xA = network.XToPositionX(i);
			Integer xB = network.XToPositionX(i+1);			
			
			if (network.isTcpTahoe()) {								
				g2d.setColor(Color.CYAN);
				Integer yA = network.YToPositionY(pointA.getCwndTcpTahoe());
				Integer yB = network.YToPositionY(pointB.getCwndTcpTahoe());
				g2d.setColor(network.getColorTcpTahoe());
				g2d.drawLine(xA, yA, xB, yB);
			}			
			if (network.isTcpReno()) {													
				g2d.setColor(Color.GRAY);
				Integer yA = network.YToPositionY(pointA.getCwndTcpReno());
				Integer yB = network.YToPositionY(pointB.getCwndTcpReno());
				g2d.setColor(network.getColorTcpReno());
				g2d.drawLine(xA, yA, xB, yB);	
			}
		}	
	}
	
	private void printSsTreshs() {		
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs);	
		
		Integer gap = network.getGapBetweenX();
		
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
					Integer x1 = network.XToPositionX(x) + 3;
					Integer x2 = network.XToPositionX(x+1) - (gap / 2);
					Integer y = network.YToPositionY(ssTreshT);
					g2d.setColor(network.getColorSsTreshTcpTahoe());
					g2d.drawLine(x1, y, x2, y);		
				}
				if (network.isTcpReno()) {
					Integer x1 = network.XToPositionX(x) + (gap / 2) + 3;
					Integer x2 = network.XToPositionX(x+1);
					Integer y = network.YToPositionY(ssTreshR);
					g2d.setColor(network.getColorSsTreshTcpReno());
					g2d.drawLine(x1, y, x2, y);	
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
	protected void createDrawing() {
		this.network = ManagementFactory.getManagementCongestionAvoidance();
	}

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
}