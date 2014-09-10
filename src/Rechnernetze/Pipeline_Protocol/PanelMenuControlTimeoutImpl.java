/**
 * @author:	Stefan Otto G�nther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.ImageIcon;

import Base.ImageLoader;
import Base.ManagementTestImpl;
import Base.PanelMenuControlSliderAbstract;

public class PanelMenuControlTimeoutImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuControlTimeoutImpl(ManagementPipelineProtocol pipeline) {
		super(pipeline);
	}
	
	private PanelMenuControlTimeoutImpl() {
		super(new ManagementTestImpl());
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
		return "Timeout:";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) management.getToolTipManager();
		return tooltip.getToolTipAutomaticSlider();
	}
}