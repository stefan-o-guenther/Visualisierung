/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelBSVerklemmungenMain extends BasePanelMain {

	public PanelBSVerklemmungenMain() {
		super();
		initComponents();
		initLayout();
	}	
	
	private PanelBSVerklemmungenTitle panelTitle;
	private PanelBSVerklemmungenMenu panelMenu;
	private PanelBSVerklemmungenModel panelModel;
	
	protected void initComponents() {
		IDeadlockManagement deadlock = new DeadlockManagement();		
		panelModel = new PanelBSVerklemmungenModel(deadlock);
		panelMenu = new PanelBSVerklemmungenMenu(deadlock, panelModel);
		panelTitle = new PanelBSVerklemmungenTitle(deadlock, panelModel);
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
