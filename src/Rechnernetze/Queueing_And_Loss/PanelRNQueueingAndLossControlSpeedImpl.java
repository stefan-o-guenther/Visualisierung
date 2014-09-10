/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.ImageIcon;

import Base.*;

public class PanelRNQueueingAndLossControlSpeedImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossControlSpeedImpl(Management management) {
		super(management);
	}
	
	private PanelRNQueueingAndLossControlSpeedImpl() {
		super(new ManagementTestImpl());
	}	

	@Override
	protected Integer getMax() {
		return 50;
	}

	@Override
	protected Integer getMin() {
		return 1;
	}

	@Override
	protected Integer getStep() {
		return 1;
	}

	@Override
	protected Integer getInit() {
		return 25;
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
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) management.getToolTipManager();
		return tooltip.getToolTipTransferRate();
	}
}
