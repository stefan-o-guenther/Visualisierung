package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import Base.BasePanelModelDraw;
import Base.EnumSurface;

public class PanelBSBuddySystemeModelDraw extends BasePanelModelDraw {

	private IBuddyMemoryAllocation buddy;
	
	private Dimension area; //indicates area taken up by graphics
	
	private List<IBuddyOperation> list = new ArrayList<IBuddyOperation>();
	
	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeModelDraw(IBuddyMemoryAllocation ibuddy) {
		if (ibuddy == null) {
			ibuddy = new BuddyMemoryAllocation();
		}
		buddy = ibuddy;
		
		
		
		/*
		String text = "hello ";
		for (int i = 0; i < 100; i++) {
			JLabel label = new JLabel(text);			
			add(label);
		}
		*/
		area = new Dimension(0,0);
	}

	@Override
	protected void doDrawing(Graphics g) {
		repaint();
		// update();
		Graphics2D g2d = (Graphics2D) g;
		
		Integer size = buddy.getTotalSpace();
		if (size > 0) {
			Integer limit = size / 512;
			buddy.limitOutput(limit);
			list = buddy.getNodeList();
			Integer length = list.size();
			if (length > 0) {
				IBuddyOperation operation = list.get(0);
				List<IProcessSpace> listps = operation.getBuddyList();
				if (listps != null) {
					Integer sum = 0;
					for (IProcessSpace ps : listps) {
						Integer x = ps.getSize();						
						Integer y = (x * 512) / size;
						g2d.setColor(Color.BLACK);
						g2d.drawRect(sum+10, 10, y, 100);
						EnumNode type = ps.getType();
						if (type != null) {
							switch (type) {
								case BUDDY: {
									g2d.setColor(Color.WHITE);
									break;
								}
								case SPACE: {
									g2d.setColor(Color.MAGENTA);
									break;
								}
								case REST: {
									g2d.setColor(Color.ORANGE);
									break;
								}
								case USED: {
									g2d.setColor(Color.GRAY);
									break;
								}
								default: {
									break;
								}
							}
							
							g2d.fillRect(sum+11, 11, y-2, 99);
							sum += y;	
						}					
					}
				}				
			}		
		}
		
	}

	@Override
	protected void update() {
		EnumSurface surface = buddy.getSurface();		
	}

}
