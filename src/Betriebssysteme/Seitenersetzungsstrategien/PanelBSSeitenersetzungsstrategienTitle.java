/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BasePanelTitle;

public class PanelBSSeitenersetzungsstrategienTitle extends BasePanelTitle {

	public PanelBSSeitenersetzungsstrategienTitle(IMemoryManager paging) {
		super(paging);
	}

	@Override
	protected String getToolTip() {
		String tooltipBSSeitenersetzungsstrategien = ""
	        + "<html>"
	        + "<p>"
	        + "Bei einem Seitenfehler wählt der Memory-Manager, sofern nicht noch Seitenrahmen frei sind,<br/>"
	        + "eine Seite aus, die verdrängt, also in die Paging-Area ausgelagert werden muss, um Platz für<br/>"
	        + "die neue Seite zu schaffen. Die Strategie, die verwendet wird, um eine zu verdrängende Seite<br/>"
	        + "auszuwählen, wird als <i>Seitenersetzungsstragegie</i> (Replacement-Stragegie) bezeichnet.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Optimal wäre, wenn alle zukünfigen Seitenzugriffe vorher bestimmt werden könnten.<br/>"
	        + "Dies ist aber nicht zu realisieren. Bedarfsgerechte Strategien, auch als <i>Demand-Paging</i><br/>"
	        + "bezeichnet, reagieren erst, wenn eine Anforderung zur Seiteneinlagerung da ist und kein<br/>"
	        + "freier Seitenrahmen mehr verfügbar ist.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Man unterscheidet prozesslokale und globale Strategien zur Seitenersetzung. Bei ersteren<br/>"
	        + "wird die Seitenersetzung für jeden Prozess isoliert durchgeführt, bei letzteren für das<br/>"
	        + "ganze System. Globale Strategien bieten mehr Möglichkeiten der Optimierung.<br/>"
	        + "</p>"
	        + "<p>"
	        + "In dieser Animation werden die folgenden Algorithmen behandelt:<br/>"
	        + "</p>"
	        + "<ul>"
	        + "<li>Optimale Strategie</li>"
	        + "<li>FIFO</li>"
	        + "<li>FIFO - Second Chance</li>"
	        + "<li>NRU / RNU mit nachgeschaltetem FIFO</li>"
	        + "<li>NRU / RNU mit nachgeschaltetem FIFO - Second Chance"
	        + "</ul>"
	        + "</html>";
		return tooltipBSSeitenersetzungsstrategien;
	}

	@Override
	protected String getTitle() {
		return "Seitenersetzungsstrategien";
	}

}
