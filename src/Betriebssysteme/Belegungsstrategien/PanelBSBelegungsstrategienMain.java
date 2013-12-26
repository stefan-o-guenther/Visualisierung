package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSBelegungsstrategienMain extends BasePanelMain {
		
	/**
	 * Create the panel.
	 */
	public PanelBSBelegungsstrategienMain() {
		super(new MemoryManagement());
		initComponents();
	}
	
	protected void initComponents() {
		IMemoryManagement memory = (IMemoryManagement) management;
				
		String tooltip = 
	        	  "<html>"
	        	+ "Unabh�ngig vom dem Mechanismus der Speicherbelegungslisten gibt es verschiedene Strategien,<br>"
	        	+ "um aus der Menge der unbelegten Speicherbereiche den geeignetsten auszusuchen.<br>"
	        	+ "Ziel der Strategien ist es, die Anzahl der freien Bereiche m�glichst klein zu halten und ihre Gr��e m�glichst gro�.<br>"
	        	+ "Die wichtigsten Strategien sind: First-Fit, Next-Fit, Best-Fit, Worst-Fit<br>"
	        	+ "</html>";
		
		panelModel = new PanelBSBelegungsstrategienModel(memory);
		panelMenu = new PanelBSBelegungsstrategienMenu(memory);
		panelTitle = new PanelTitle("Belegungsstrategien", tooltip, memory);		
		initLayout(160);
	}
}