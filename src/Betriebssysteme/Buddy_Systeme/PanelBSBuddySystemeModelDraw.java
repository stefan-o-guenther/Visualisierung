/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Base.BasePanelModelDraw;

public class PanelBSBuddySystemeModelDraw extends BasePanelModelDraw {

	public PanelBSBuddySystemeModelDraw(IBuddyMemoryAllocation buddy) {
		super(buddy);
		this.buddy = buddy;
		updateModel();
	}

	private IBuddyMemoryAllocation buddy;
	private List<IBuddyOperation> list = new ArrayList<IBuddyOperation>();	
	
	private Graphics2D g2d;
	
	private final Integer WIDTH = 512;
	private final Integer HEIGHT = 20;
	private final Integer GAP_X = 10;
	private final Integer GAP_Y = 10;	
	
	@Override
	public void doDrawing(Graphics g) {
		g2d = (Graphics2D) g;
		Integer height = 0;
		Integer size = buddy.getTotalSpace();					
		if (size > 0) {
			list = buddy.getNodeList();
			Integer length = list.size();			
			for (Integer i = 0; i < length; i++) {
				IBuddyOperation operation = list.get(i);				
				List<IBuddySpace> listps = operation.getBuddyList();
				if (listps != null) {
					Integer sum = 0;
					for (IBuddySpace ps : listps) {
						Integer widthNode = (ps.getSize() * WIDTH) / size;;						
						g2d.setColor(Color.BLACK);
						g2d.drawRect(sum+GAP_X, i*(HEIGHT+GAP_Y)+GAP_Y, widthNode, HEIGHT);
						EnumNode type = ps.getType();
						if (type != null) {
							Color color = null;
							switch (type) {
								case BUDDY: {
									color = buddy.getBuddyColor();
									break;
								}
								case SPACE: {									
									color = buddy.getProcessNodeColor(ps.getName());
									break;
								}
								case REST: {
									color = buddy.getRestColor();
									break;
								}
								case USED: {
									color = buddy.getUsedColor();
									break;
								}
								default: {
									color = Color.WHITE;
									break;
								}
							}
							g2d.setColor(color);
							g2d.fillRect(sum+GAP_X+1, i*(HEIGHT+GAP_Y)+GAP_Y+1, widthNode-1, HEIGHT-1);
							if (type == EnumNode.SPACE) {
								g2d.setColor(Color.BLACK);
								g2d.drawString(ps.getName(), sum+GAP_X+2, i*(HEIGHT+GAP_Y)+GAP_Y+15);
							}
							
							
							sum += widthNode;	
						}					
					}
					g2d.setColor(Color.BLACK);
					g2d.drawString(operation.getMessage(), WIDTH+20, i*(HEIGHT+GAP_Y)+GAP_Y+5+(HEIGHT/2));
				}				
			}
			height = (length-1)*(HEIGHT+GAP_Y)+GAP_Y+HEIGHT+GAP_Y;
		}
		Dimension area = new Dimension(0,0);		
		area.height = height;											                
        setPreferredSize(area);
        revalidate();
	}
	
	protected void updateData() {
		
	}

	@Override
	public void updateModel() {
		updateData();
		repaint();
	}

}
