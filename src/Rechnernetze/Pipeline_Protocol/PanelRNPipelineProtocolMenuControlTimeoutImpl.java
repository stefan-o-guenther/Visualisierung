/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.ImageIcon;

import Base.ImageLoader;
import Base.PanelMenuControlSliderAbstract;

public class PanelRNPipelineProtocolMenuControlTimeoutImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNPipelineProtocolMenuControlTimeoutImpl() {
		super(ManagementARQImpl.getInstance());
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
		
	}

	@Override
	protected String getLabel() {
		return "Timeout:";
	}

	@Override
	protected String getToolTip() {
		ToolTipManagerARQ tooltip = (ToolTipManagerARQ) management.getToolTipManager();
		return tooltip.getToolTipAutomaticSlider();
	}
}
