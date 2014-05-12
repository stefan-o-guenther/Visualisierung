/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import Base.PanelModelDrawAbstract;

public class PanelBSBuddySystemeExplanationDrawImpl extends PanelModelDrawAbstract {

	public PanelBSBuddySystemeExplanationDrawImpl(ManagerBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
		this.buddy = buddy;
		updateModel();
	}

	private ManagerBuddyMemoryAllocation buddy;	
	private Graphics2D g2d;
	
	private final Integer LENGTH = 15;
	
	private void drawLine(String text, Color color, Integer line) {
		if ((text != null) && (color != null) && (line != null) && (line >= 0)) {			
			g2d.setColor(Color.BLACK);
			g2d.drawString(text, LENGTH+5, (line*LENGTH)+LENGTH-2);
			g2d.drawRect(0, line*LENGTH, LENGTH, LENGTH);
			g2d.setColor(color);
			g2d.fillRect(1, (line*LENGTH)+1, LENGTH-1, LENGTH-1);			
		}
	}
	
	@Override
	public void doDrawing(Graphics g) {
		g2d = (Graphics2D) g;
		setBackground(Color.WHITE);
		Integer line = 0;
		drawLine("Frei",buddy.getBuddyColor(),line);
		line += 1;
		drawLine("Verschnitt",buddy.getRestColor(),line);
		List<ProcessNode> listProcesses = buddy.getListRunningProcesses();
		if (listProcesses != null) {
			for (ProcessNode pn : listProcesses) {				
				BuddyNode parent = pn.getParent();
				RestNode rest = parent.getRestNode();
				Integer restValue = rest.getValue();
				Integer processValue = pn.getValue();
				line += 1;
				String name = pn.getName();
				String text = name + " (" + processValue + " / " + restValue + ")";
				Color color = buddy.getProcessNodeColor(name);
				drawLine(text,color,line);
			}		
		}
	}
	
	@Override
	public void initComponents() {
		// nothing
	}
}
