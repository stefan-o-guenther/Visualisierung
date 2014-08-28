/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelDefaultMainImpl extends PanelMainAbstract {
	
	public PanelDefaultMainImpl() {
		super(new ManagementDefaultImpl(), new ToolTipManagerDefaultImpl());
	}	

	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementDefault main = (ManagementDefault) this.getManagement();
		ToolTipManagerDefault tooltip = (ToolTipManagerDefault) this.getToolTipManager();
		return new PanelDefaultMenuImpl(main, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementDefault main = (ManagementDefault) this.getManagement();
		ToolTipManagerDefault tooltip = (ToolTipManagerDefault) this.getToolTipManager();
		return new PanelDefaultModelImpl(main, tooltip);
	}
}
