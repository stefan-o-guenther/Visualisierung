/**
 * @author:	Stefan Otto G�nther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.ImageIcon;

import Base.*;

public class PanelRNQueueingAndLossControlIntervalImpl extends PanelControlSliderAbstract {

	private static final long serialVersionUID = 1L;	

	public PanelRNQueueingAndLossControlIntervalImpl() {
		super(ManagementFactory.getManagementQueueingAndLoss());
		this.createPanel();
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
		return ImageLoader.getImageIconTimeout02();
	}

	@Override
	protected ImageIcon getImageIconRight() {
		return ImageLoader.getImageIconTimeout01();		
	}

	@Override
	protected Boolean isInverted() {
		return true;
	}

	@Override
	protected void setSliderValueToManagement(Integer value) {
		ManagementQueueingAndLoss qal = ManagementFactory.getManagementQueueingAndLoss();
		qal.setIntervalPacket(value);
	}

	@Override
	protected String getLabel() {
		return "Ankuftsrate (Paketabstand):";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerQueueingAndLoss tooltip = ToolTipManagerQueueingAndLossImpl.getInstance();
		return tooltip.getToolTipInterval();
	}

	@Override
	protected Boolean isLabelsEnabled() {
		return false;
	}
}
