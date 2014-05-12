/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Betriebssysteme.Belegungsstrategien;

public class ToolTipManagerFragmentationImpl implements ToolTipManagerFragmentation {

	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
			+ "<p>"
			+ "Es gibt verschiedene Strategien, um aus der Menge der unbelegten Speicherbereiche<br/>"
			+ "den geeignetsten auszusuchen. Ziel der Strategien ist es, die noch freien Speicherbereiche<br/>"
			+ "m&ouml;glichst geschickt mit Prozessanforderungen abzugleichen.<br/>"
			+ "</p>"
			+ "Die wichtigsten Strategien ohne internen Verschnitt sind:"
			+ "<ul>"
			+ "<li>First-Fit</li>"
			+ "<li>Next-Fit</li>"
			+ "<li>Best-Fit</li>"
			+ "<li>Worst-Fit</li>"
			+ "</ul>"
			+ "</html>";		
		return tooltipTitle;
	}
	
	public String getToolTipStratgy() {
		String tooltipStrategy = ""
			+ "<html>"
	    	+ "<h3>First-Fit:</h3>"
	    	+ "W&auml;hle den ersten Speicherblock, der ausreichend<br>"
	    	+ "gro&szlig; ist.<br>"
	    	+ "<br>"
	    	+ "<h3>Next-Fit:</h3>"
	    	+ "Dasselbe Prinzip wie bei First-Fit, nur wird hier<br>"
	    	+ "die Suche nicht wieder von vorn begonnen,<br>"
	    	+ "sondern beim letzten Treffer fortgesetzt.<br>"
	    	+ "<br>"
	    	+ "<h3>Best-Fit:</h3>"
	    	+ "Es wird der Speicherblock gew&auml;hlt, bei dem am<br>"
	    	+ "wenigsten Rest bzw. Verschnitt &uuml;brig bleibt.<br>"
	    	+ "<br>"
	    	+ "<h3>Worst-Fit:</h3>"
	    	+ "Genau das Gegenteil von Best-Fit. Es wird der<br>"
	    	+ "Speicherblock gew&auml;hlt, bei dem am meisten Rest<br>"
	    	+ "bzw. Verschnitt &uuml;brig bleibt.<br><br>"
	    	+ "</html>";
		return tooltipStrategy;
	}
	
	public String getToolTipSpeicher() {
		String tooltipSpeicher = ""
	    	+ "<html>"
	    	+ "ganze Zahl, die gr&ouml;&szlig;er als Null ist, eintragen"
	    	+ "</html>";
		return tooltipSpeicher;
	}
}
