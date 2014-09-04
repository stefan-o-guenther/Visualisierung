package Rechnernetze.Queueing_And_Loss;

import javax.swing.ImageIcon;

import Base.*;

public class PanelRNQueueingAndLossControlSpeedImpl extends PanelMenuControlSliderAbstract {

	public PanelRNQueueingAndLossControlSpeedImpl(Management management) {
		super(management);
	}
	
	public PanelRNQueueingAndLossControlSpeedImpl() {
		super(new ManagementTestImpl());
	}	

	@Override
	protected Integer getMax() {
		return 200;
	}

	@Override
	protected Integer getMin() {
		return 10;
	}

	@Override
	protected Integer getStep() {
		return 10;
	}

	@Override
	protected Integer getInit() {
		return 50;
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
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		qal.setTransferRate(value);
	}

	@Override
	protected String getLabel() {
		return "Übertragungsrate Eingang:";
	}

	@Override
	protected String getToolTip() {
		// TODO Auto-generated method stub
		return null;
	}
}
