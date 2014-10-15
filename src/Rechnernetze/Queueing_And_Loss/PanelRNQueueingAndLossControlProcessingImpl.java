/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.ImageIcon;

import Base.*;

public class PanelRNQueueingAndLossControlProcessingImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;	

	public PanelRNQueueingAndLossControlProcessingImpl() {
		super(ManagementQALImpl.getInstance());
		this.createPanel();
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
		ManagementQAL qal = ManagementQALImpl.getInstance();
		qal.setProcessingTime(value);
	}

	@Override
	protected String getLabel() {
		return "Verarbeitungszeit:";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerQueueingAndLoss tooltip = ToolTipManagerQueueingAndLossImpl.getInstance();
		return tooltip.getToolTipProcessing();
	}
}
