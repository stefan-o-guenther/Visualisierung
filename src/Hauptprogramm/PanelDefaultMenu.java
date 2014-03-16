/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.BasePanelMenu;

public class PanelDefaultMenu extends BasePanelMenu {

	private IDefaultManagement main;
	
	public PanelDefaultMenu(IDefaultManagement main) {
		super(main);
		this.main = main;
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}

}
