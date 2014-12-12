/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import javax.swing.ImageIcon;

public class PanelControlSpeedPacketImpl extends PanelControlSliderAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelControlSpeedPacketImpl(ManagementPacket managementPacket, String label) {
		super(managementPacket);
		Checker.checkIfNotNull(managementPacket);
		Checker.checkIfString(label);
		this.managementPacket = managementPacket;
		this.label = label;
		this.createPanel();
	}
	
	private ManagementPacket managementPacket;
	private String label;
	
	@Override
	protected Integer getMax() {
		return 40;
	}

	@Override
	protected Integer getMin() {
		return 6;
	}

	@Override
	protected Integer getStep() {
		return 2;
	}

	@Override
	protected Integer getInit() {
		return 24;
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
		managementPacket.setSpeedPacket(value);
	}

	@Override
	protected String getLabel() {
		return label;
	}

	@Override
	protected String getToolTip() {
		if (managementPacket == null) {
			System.out.println("null");
		}
		ToolTipManagerSpeedPacket tooltip = (ToolTipManagerSpeedPacket) managementPacket.getToolTipManager();
		return tooltip.getToolTipSpeedPacket();
	}

	@Override
	protected Boolean isLabelsEnabled() {
		return false;
	}
}
