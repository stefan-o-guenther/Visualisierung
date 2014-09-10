/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import javax.swing.ImageIcon;

public class PanelMenuControlSpeedVisualizationImpl extends PanelMenuControlSliderAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuControlSpeedVisualizationImpl(Management management) {
		super(management);
	}
	
	private PanelMenuControlSpeedVisualizationImpl() {
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
		return "Geschwindigkeit:";
	}

	@Override
	protected String getToolTip() {
		ToolTipManager tooltip = management.getToolTipManager();
		return tooltip.getToolTipAutomaticSlider();
	}
}
