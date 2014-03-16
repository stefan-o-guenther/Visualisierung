/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelDefaultMain extends BasePanelMain {
	
	public PanelDefaultMain() {
		super();
		initComponents();
		initLayout();
	}	

	private PanelDefaultTitle panelTitle;
	private PanelDefaultMenu panelMenu;
	private PanelDefaultModel panelModel;
	
	public void initComponents() {
		IDefaultManagement main = new DefaultManagement();
		panelModel = new PanelDefaultModel(main);
		panelMenu = new PanelDefaultMenu(main);
		panelTitle = new PanelDefaultTitle(main);
	}

	@Override
	public BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	public BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	public BasePanelModel getPanelModel() {
		return panelModel;
	}
}
