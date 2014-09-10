/**
 * @author:	Stefan Otto G�nther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.ImageIcon;

import Base.*;

public class PanelRNQueueingAndLossControlIntervalImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;	

	public PanelRNQueueingAndLossControlIntervalImpl(Management management) {
		super(management);
	}
	
	private PanelRNQueueingAndLossControlIntervalImpl() {
		super(new ManagementTestImpl());
	}	

	@Override
	protected Integer getMax() {
		return 200;
	}

	@Override
	protected Integer getMin() {
		return 30;
	}

	@Override
	protected Integer getStep() {
		return 10;
	}

	@Override
	protected Integer getInit() {
		return 100;
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
		return false;
	}

	@Override
	protected void setSliderValueToManagement(Integer value) {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		qal.setPacketInterval(value);
	}

	@Override
	protected String getLabel() {
		return "Ankuftsrate (Paketabstand):";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) management.getToolTipManager();
		return tooltip.getToolTipInterval();
	}
}
