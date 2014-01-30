/**
 * @author:	Stefan Otto G�nther
 * @date:	29.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelTitle;

public class PanelBSBelegungsstrategienTitle extends BasePanelTitle {

	public PanelBSBelegungsstrategienTitle(IMemoryManagement memory, PanelBSBelegungsstrategienModel model) {
		super(memory, model);
	}
	
	@Override
	protected String getToolTip() {
		String tooltipBSBelegungsstrategie = ""
			+ "<html>"
			+ "<p>"
			+ "Unabh�ngig vom dem Mechanismus der Speicherbelegungslisten gibt es<br/>"
			+ "verschiedene Strategien, um aus der Menge der unbelegten Speicherbereiche<br/>"
			+ "den geeignetsten auszusuchen. Ziel der Strategien ist es, die Anzahl der<br/>"
			+ "freien Bereiche m�glichst klein zu halten und ihre Gr��e m�glichst gro�.<br/>"
			+ "</p>"
			+ "Die wichtigsten Strategien sind:"
			+ "<ul>"
			+ "<li>First-Fit</li>"
			+ "<li>Next-Fit</li>"
			+ "<li>Best-Fit</li>"
			+ "<li>Worst-Fit</li>"
			+ "</ul>"
			+ "</html>";		
		return tooltipBSBelegungsstrategie;
	}

	@Override
	protected String getTitle() {
		return "Belegungsstrategien";
	}
}
