package Rechnernetze.Queueing_And_Loss.Example;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Content extends Panel {

	private Button start = new Button("Start");
	private Button reset = new Button("Reset");
	private MyChoice emitRate = new MyChoice(new String[] {"500  packet/s","350 packet/s"}, new double[] {2E-3,3E-3},1);
	private MyChoice processorRate = new MyChoice(new String[] {"1000 packet/s","500  packet/s","350 packet/s"}, new double[] {1E-3,2E-3,3E-3},3);
	private SimTimer myTimer;
	
	/**
	 * Create the panel.
	 */
	public Content() {
		try {
			myTimer = new SimTimer(1E-4,1000,this);
			start.addActionListener(actionStart);
			reset.addActionListener(actionReset);
			setBackground(Color.white);
			add(new Label("Emission rate", Label.RIGHT));
			add(emitRate);
			add(new Label("Transmission rate", Label.RIGHT));
			add(processorRate);	
			add(start);	
			add(reset);
		} catch(Exception e) {
			
		}
	}	

	public void paint (Graphics g) {
		update(g); // eliminate flashing : update is overriden
	}
	
	public void update (Graphics g) {
		//work on a offscreen image
		Dimension offDimension = getSize();
		Image offImage = createImage(offDimension.width, offDimension.height);
		Graphics offGraphics = offImage.getGraphics();
		myTimer.draw(offGraphics);
		g.drawImage(offImage, 0, 0, this);
	}
	
	private ActionListener actionStart = new ActionListener() {
		public void actionPerformed (ActionEvent event) {
			emitRate.setEnabled(false);
			processorRate.setEnabled(false);
			start.setEnabled(false);
			myTimer.launchSim(emitRate.getVal(), processorRate.getVal());
		}
			
	};
	
	private ActionListener actionReset = new ActionListener() {
		public void actionPerformed (ActionEvent event) {
			emitRate.setEnabled(true);
			processorRate.setEnabled(true);
			start.setEnabled(true);
			myTimer = new SimTimer(1E-4,1000,Content.this);
		}
	};
}
