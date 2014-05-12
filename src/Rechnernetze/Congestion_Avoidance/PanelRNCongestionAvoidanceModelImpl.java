/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import Base.PanelModelDrawAbstract;

public class PanelRNCongestionAvoidanceModelImpl extends PanelModelDrawAbstract {

	public PanelRNCongestionAvoidanceModelImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		if (network == null) {
			network = new ManagementCongestionAvoidanceImpl();
		}
		this.network = network;
		putModelToManagement();
		updateModel();
	}

	private ManagementCongestionAvoidance network;
	private Integer xMin = 20;
	private Integer yMin = 530;
	private Integer xMax = 950;
	private Integer yMax = 0;
	
	@Override
	public void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawLine(20, 0, 20, 530);
		g2d.drawLine(20, 0, 10, 30);
		g2d.drawLine(20, 0, 30, 30);
		g2d.drawLine(10, 30, 30, 30);		
		
		g2d.drawLine(20, 530, 950, 530);
		g2d.drawLine(950, 530, 920, 520);
		g2d.drawLine(950, 530, 920, 540);
		g2d.drawLine(920, 520, 920, 540);
		
		List<Point> listPoints = network.getListPoints();
		
		Integer size = listPoints.size();
		
		Integer xOld = 0;
		Integer yOld = 0;
		
		for (Integer i = 0; i < size; i++) {
			Point point = listPoints.get(i);
			Integer x = xMin + (point.getTransmissionRound() * 10);
			Integer y = yMin - (point.getCwndTcpReno() * 10);
			if (i > 0) {				
				g2d.drawLine(xOld, yOld, x, y);
			}
			xOld = x;
			yOld = y;
		}		
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}
}