/**
 * @author:	Stefan Otto Günther
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
			+ "Unabhängig vom dem Mechanismus der Speicherbelegungslisten gibt es<br/>"
			+ "verschiedene Strategien, um aus der Menge der unbelegten Speicherbereiche<br/>"
			+ "den geeignetsten auszusuchen. Ziel der Strategien ist es, die Anzahl der<br/>"
			+ "freien Bereiche möglichst klein zu halten und ihre Größe möglichst groß.<br/>"
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
