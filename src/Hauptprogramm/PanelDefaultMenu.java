/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelDefaultMenu extends BasePanelMenu {

	private IDefaultManagement main;
	
	/**
	 * Create the panel.
	 */
	public PanelDefaultMenu(IDefaultManagement imain, BasePanelModel modeldraw) {
		super(modeldraw);
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
