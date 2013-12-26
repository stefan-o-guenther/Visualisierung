package Hauptprogramm;

import Base.BasePanelMenu;

public class PanelDefaultMenu extends BasePanelMenu {

	IDefaultManagement main;
	
	/**
	 * Create the panel.
	 */
	public PanelDefaultMenu(IDefaultManagement imain) {
		if (imain == null) {
			imain = new DefaultManagement();
		}
		main = imain;
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

}
