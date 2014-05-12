/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.PanelMenuAbstract;

public class PanelDefaultMenuImpl extends PanelMenuAbstract {
	
	public PanelDefaultMenuImpl(ManagementDefault main, ToolTipManagerDefault tooltip) {
		super(main, tooltip);		
	}
	
	@Override
	protected void initComponents() {
		
	}
	
	@Override
	protected void initLayout() {
		
	}

	@Override
	public void updateComponents() {
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}
}