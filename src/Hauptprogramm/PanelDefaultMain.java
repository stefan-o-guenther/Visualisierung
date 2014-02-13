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
	
	protected void initComponents() {
		IDefaultManagement main = new DefaultManagement();
		panelModel = new PanelDefaultModel(main);
		panelMenu = new PanelDefaultMenu(main);
		panelTitle = new PanelDefaultTitle(main);
	}

	@Override
	protected BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	protected BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	protected BasePanelModel getPanelModel() {
		return panelModel;
	}
}
