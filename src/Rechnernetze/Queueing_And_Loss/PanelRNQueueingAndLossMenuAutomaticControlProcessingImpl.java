package Rechnernetze.Queueing_And_Loss;

import javax.swing.ImageIcon;

import Base.*;

public class PanelRNQueueingAndLossMenuAutomaticControlProcessingImpl extends PanelMenuControlSliderAbstract {

	public PanelRNQueueingAndLossMenuAutomaticControlProcessingImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	public PanelRNQueueingAndLossMenuAutomaticControlProcessingImpl() {
		super(new ManagementTestImpl(), new ToolTipManagerTestImpl());
	}	

	@Override
	protected Integer getMax() {
		return 2000;
	}

	@Override
	protected Integer getMin() {
		return 125;
	}

	@Override
	protected Integer getStep() {
		return 125;
	}

	@Override
	protected Integer getInit() {
		return 1000;
	}

	@Override
	protected ImageIcon getImageIconLeft() {
		return ImageLoader.getImageIconTurtle();
	}

	@Override
	protected ImageIcon getImageIconRight() {
		return ImageLoader.getImageIconRabbit();
	}

	@Override
	protected Boolean isInverted() {
		return true;
	}

	@Override
	protected void setSliderValueToManagement(Integer value) {
		if (management != null) {
			management.setSpeed(value);
		}
	}

	@Override
	protected String getLabel() {
		return "Verarbeitungszeit:";
	}

	@Override
	protected String getToolTip() {
		// TODO Auto-generated method stub
		return null;
	}
}
