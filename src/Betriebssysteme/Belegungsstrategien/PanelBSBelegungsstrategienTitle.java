/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelTitle;

public class PanelBSBelegungsstrategienTitle extends BasePanelTitle {

	public PanelBSBelegungsstrategienTitle(IFragmentation memory) {
		super(memory);
	}
	
	@Override
	protected String getToolTip() {
		String tooltipBSBelegungsstrategie = ""
			+ "<html>"
			+ "<p>"
			+ "Es gibt verschiedene Strategien, um aus der Menge der unbelegten Speicherbereiche<br/>"
			+ "den geeignetsten auszusuchen. Ziel der Strategien ist es, die noch freien Speicherbereiche<br/>"
			+ "möglichst geschickt mit Prozessanforderungen abzugleichen.<br/>"
			+ "</p>"
			+ "Die wichtigsten Strategien ohne internen Verschnitt sind:"
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
