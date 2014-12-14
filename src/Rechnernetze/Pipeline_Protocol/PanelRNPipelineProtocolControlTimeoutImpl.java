/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.ImageIcon;

import Base.ImageLoader;
import Base.ManagementFactory;
import Base.PanelControlSliderAbstract;

public class PanelRNPipelineProtocolControlTimeoutImpl extends PanelControlSliderAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNPipelineProtocolControlTimeoutImpl() {
		super(ManagementFactory.getManagementAutomaticRepeatRequest());
		this.createPanel();
	}
	
	@Override
	protected Integer getMax() {
		return 60;
	}

	@Override
	protected Integer getMin() {
		return 5;
	}

	@Override
	protected Integer getStep() {
		return 5;
	}

	@Override
	protected Integer getInit() {
		return 15;
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
		ManagementAutomaticRepeatRequest pipeline = ManagementFactory.getManagementAutomaticRepeatRequest();
		pipeline.setTimeout(value);
	}

	@Override
	protected String getLabel() {
		return "Timeout:";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerARQ tooltip = (ToolTipManagerARQ) management.getToolTipManager();
		return tooltip.getToolTipTimeout();
	}

	@Override
	protected Boolean isLabelsEnabled() {
		return true;
	}
}
