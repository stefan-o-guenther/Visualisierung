/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.ImageIcon;

import Base.ImageLoader;
import Base.PanelMenuControlSliderAbstract;

public class PanelRNPipelineProtocolMenuControlSpeedImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNPipelineProtocolMenuControlSpeedImpl() {
		super(ManagementARQImpl.getInstance());
		this.createPanel();
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
		ManagementARQ pipeline = ManagementARQImpl.getInstance();
		pipeline.setPacketSpeed(value);
	}

	@Override
	protected String getLabel() {
		return "Geschwindigkeit:";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerARQ tooltip = (ToolTipManagerARQ) management.getToolTipManager();
		return tooltip.getToolTipAutomaticSlider();
	}
}
