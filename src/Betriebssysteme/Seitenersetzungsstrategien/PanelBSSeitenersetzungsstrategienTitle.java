/**
 * @author:	Stefan Otto G�nther
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
	        + "Bei einem Seitenfehler w�hlt der Memory-Manager, sofern nicht noch Seitenrahmen frei sind,<br/>"
	        + "eine Seite aus, die verdr�ngt, also in die Paging-Area ausgelagert werden muss, um Platz f�r<br/>"
	        + "die neue Seite zu schaffen. Die Strategie, die verwendet wird, um eine zu verdr�ngende Seite<br/>"
	        + "auszuw�hlen, wird als <i>Seitenersetzungsstragegie</i> (Replacement-Stragegie) bezeichnet.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Optimal w�re, wenn alle zuk�nfigen Seitenzugriffe vorher bestimmt werden k�nnten.<br/>"
	        + "Dies ist aber nicht zu realisieren. Bedarfsgerechte Strategien, auch als <i>Demand-Paging</i><br/>"
	        + "bezeichnet, reagieren erst, wenn eine Anforderung zur Seiteneinlagerung da ist und kein<br/>"
	        + "freier Seitenrahmen mehr verf�gbar ist.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Man unterscheidet prozesslokale und globale Strategien zur Seitenersetzung. Bei ersteren<br/>"
	        + "wird die Seitenersetzung f�r jeden Prozess isoliert durchgef�hrt, bei letzteren f�r das<br/>"
	        + "ganze System. Globale Strategien bieten mehr M�glichkeiten der Optimierung.<br/>"
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
