/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelBSSeitenersetzungsstrategienMain extends BasePanelMain {
	
	public PanelBSSeitenersetzungsstrategienMain() {
		super();
		initComponents();
		initLayout();
	}
	
	private PanelBSSeitenersetzungsstrategienTitle panelTitle;
	private PanelBSSeitenersetzungsstrategienMenu panelMenu;
	private PanelBSSeitenersetzungsstrategienModel panelModel;
		
	protected void initComponents() {
		IPaging paging = new Paging();		
		panelModel = new PanelBSSeitenersetzungsstrategienModel(paging);
		panelMenu = new PanelBSSeitenersetzungsstrategienMenu(paging);
		panelTitle = new PanelBSSeitenersetzungsstrategienTitle(paging);		
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