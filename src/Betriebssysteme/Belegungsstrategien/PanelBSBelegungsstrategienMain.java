/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelBSBelegungsstrategienMain extends BasePanelMain {
		
	public PanelBSBelegungsstrategienMain() {
		super();
		initComponents();
		initLayout();
	}
	
	private static final long serialVersionUID = 1L;

	private PanelBSBelegungsstrategienTitle panelTitle;
	private PanelBSBelegungsstrategienMenu panelMenu;
	private PanelBSBelegungsstrategienModel panelModel;	
	
	protected void initComponents() {
		IMemoryManagement memory = new MemoryManagement();
		panelModel = new PanelBSBelegungsstrategienModel(memory);
		panelMenu = new PanelBSBelegungsstrategienMenu(memory);
		panelTitle = new PanelBSBelegungsstrategienTitle(memory);		
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