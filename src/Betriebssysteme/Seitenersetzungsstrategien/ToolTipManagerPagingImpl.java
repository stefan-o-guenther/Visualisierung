/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerPagingImpl extends ToolTipManagerAbstract implements ToolTipManagerPaging {

	public String getToolTipTitle() {
		String tooltipTitle = ""
	        + "<html>"
	        + "<p>"
	        + "Bei einem Seitenfehler wählt der Memory-Manager, sofern nicht noch Seitenrahmen frei sind,<br/>"
	        + "eine Seite aus, die verdrängt, also in die Paging-Area ausgelagert werden muss, um Platz f&uuml;r<br/>"
	        + "die neue Seite zu schaffen. Die Strategie, die verwendet wird, um eine zu verdrängende Seite<br/>"
	        + "auszuwählen, wird als <i>Seitenersetzungsstragegie</i> (Replacement-Stragegie) bezeichnet.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Optimal wäre, wenn alle zuk&uuml;nfigen Seitenzugriffe vorher bestimmt werden k&ouml;nnten.<br/>"
	        + "Dies ist aber nicht zu realisieren. Bedarfsgerechte Strategien, auch als <i>Demand-Paging</i><br/>"
	        + "bezeichnet, reagieren erst, wenn eine Anforderung zur Seiteneinlagerung da ist und kein<br/>"
	        + "freier Seitenrahmen mehr verf&uuml;gbar ist.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Man unterscheidet prozesslokale und globale Strategien zur Seitenersetzung. Bei ersteren<br/>"
	        + "wird die Seitenersetzung f&uuml;r jeden Prozess isoliert durchgef&uuml;hrt, bei letzteren f&uuml;r das<br/>"
	        + "ganze System. Globale Strategien bieten mehr M&ouml;glichkeiten der Optimierung.<br/>"
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
		return tooltipTitle;
	}
	
	public String getToolTipStrategy() {
		String tooltipStrategy = ""
			+ "<html>"
			+ "<h3>Optimale Strategie:</h3>"
	    	+ "Das beste w&auml;re, wenn die Seitenersetzung immer die zuk&uuml;nfigen Seitenzugriffe aller Prozesse ber&uuml;cksichtigen<br/>"
	    	+ "k&ouml;nnte, weil dann wenige Seitenfehler auftreten w&uuml;rden. Ein optimaler Algorithmus w&uuml;rde die Seitenrahmen f&uuml;r<br/>"
	    	+ "eine Ersetzung ausw&auml;hlen, die am sp&auml;testen von allen belegten Seitenrahmen wieder ben&ouml;tigt w&uuml;rden.<br/>"
	    	+ "<br/>"
	    	+ "<h3>FIFO</h3>"
	    	+ "Bei <i>FIFO</i> (First In First Out) wird die zuerst eingespeicherte Seite ersetzt.<br/>"
	    	+ "<br/>"
	    	+ "<h3>FIFO - Second Chance</h3>"
	    	+ "Der <i>Second-Chance-Algorithmus</i> ist eine Verbesserung von <i>FIFO</i> dahingehend, dass nochmals referenzierte<br/>"
	    	+ "Seiten imHauptspeicher wie neu eingelagerte Seiten behandelt werden.<br/>"
	    	+ "<br/>"
	    	+ "<h3>NRU / RNU - FIFO</h3>"
	    	+ "Seiten werden &uuml;ber R- und M-Bits priorisiert. Seiten mit kleinster Priorit&auml;t werden als erstes ersetzt.<br/>"
	    	+ "Die Priorit&auml;tenreihenfolge von niedrig nach hoch ist: R/M = 0/0, 0/1, 1/0, 1/1.<br/>"
	    	+ "Wenn mehrere Seiten mit gleicher Priorit&auml;t f&uuml;r eine Ersetzung in Frage kommen, so wird FIFO angewendet.<br/>"
	    	+ "<br/>"
	    	+ "<h3>NRU / RNU - FIFO Second Chance</h3>"
	    	+ "Seiten werden &uuml;ber R- und M-Bits priorisiert. Seiten mit kleinster Priorit&auml;t werden als erstes ersetzt.<br/>"
	    	+ "Die Priorit&auml;tenreihenfolge von niedrig nach hoch ist: R/M = 0/0, 0/1, 1/0, 1/1.<br/>"
	    	+ "Wenn mehrere Seiten mit gleicher Priorit&auml;t f&uuml;r eine Ersetzung in Frage kommen, so wird FIFO - Second Chance<br/>"
	    	+ "angewendet.<br/>"
	    	+ "</html>";	
		return tooltipStrategy;
	}
	
	public String getToolTipReference() {
		String tooltipReference = ""
			+ "<html>"
	    	+ "<span>"
	    	+ "Die Eingabel&auml;nge der Referenzfolge ist f&uuml;r diese Animation auf 26 Seiten beschr&auml;nkt.<br/>"
	    	+ "Seiten werden durch einzelne Ziffern (0-9) identifiziert.<br/>"
	    	+ "Die Referenzfolge ist die Reihenfolge der Seitenzugriffe bzw. gibt an,<br/>"
	    	+ "auf welche Seiten als n&auml;chstes zugegriffen wird.<br/>"
	    	+ "</span>"
	    	+ "</html>";
		return tooltipReference;
	}
	
	public String getToolTipRam() {
		String tooltipRam = ""
			+ "<html>"
		  	+ "Anzahl RAM-Seiten"
		  	+ "</html>";
		return tooltipRam;
	}
		
	public String getToolTipDisk() {
		String tooltipDisk = ""
			+ "<html>"
		  	+ "Anzahl Disk-Seiten"
		  	+ "</html>";
		return tooltipDisk;
	}
	
	public String getToolTipPagingError() {
		String tooltipPagingError = ""
			+ "<html>"
		  	+ "wie oft wurde im RAM eine Seite durch eine andere Seite ersetzt"
		  	+ "</html>";
		return tooltipPagingError;
	}
	
	public String getToolTipR() {
		String tooltipR = ""
			+ "<html>"
		  	+ "f&uuml;r gew&ouml;hlich setzt der Pageout-D&auml;mon das R-Bit in<br/>"
		  	+ "regelm&auml;&szlig;igen Abst&auml;nden zur&uuml;ck.<br/>"
		  	+ "</html>";
		return tooltipR;
	}
	
	public String getToolTipM() {
		String tooltipM = ""
			+ "<html>"
		  	+ "Seite wurde geschrieben/ver&auml;ndert"
		  	+ "</html>";
		return tooltipM;
	}

	@Override
	public String getToolTipOldStates() {
		String tooltipOldStates = ""
			+ "<html>"
		  	+ "alte Zust&auml;nde von R und M werden angezeigt"
		  	+ "</html>";
		return tooltipOldStates;
	}
}
