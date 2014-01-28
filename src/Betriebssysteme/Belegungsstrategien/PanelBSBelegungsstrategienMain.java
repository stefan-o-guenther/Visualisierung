/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSBelegungsstrategienMain extends BasePanelMain {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	        	+ "Unabhängig vom dem Mechanismus der Speicherbelegungslisten gibt es verschiedene Strategien,<br>"
	        	+ "um aus der Menge der unbelegten Speicherbereiche den geeignetsten auszusuchen.<br>"
	        	+ "Ziel der Strategien ist es, die Anzahl der freien Bereiche möglichst klein zu halten und ihre Größe möglichst groß.<br>"
	        	+ "Die wichtigsten Strategien sind: First-Fit, Next-Fit, Best-Fit, Worst-Fit<br>"
	        	+ "</html>";
		
		panelModel = new PanelBSBelegungsstrategienModel(memory);
		panelMenu = new PanelBSBelegungsstrategienMenu(memory, panelModel);
		panelTitle = new PanelTitle(memory, panelModel, "Belegungsstrategien", tooltip);		
		initLayout(160);
	}
}