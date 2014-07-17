/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.ToolTipManagerAutomaticAbstract;

public class ToolTipManagerFragmentationImpl extends ToolTipManagerAutomaticAbstract implements ToolTipManagerFragmentation {

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
			+ "<li>Schneiderinnen-Best-Fit</li>"
			+ "</ul>"
			+ "</html>";		
		return tooltipTitle;
	}
	
	public String getToolTipStratgy() {
		String tooltipStrategy = ""
			+ "<html>"
	    	+ "<h3>First-Fit:</h3>"
	    	+ "Die Liste der Speicherbl&ouml;cke wird ab dem ersten bis zum letzten Speicherblock in der Liste durchsucht.<br/>"
	    	+ "Wenn ein Speicherblock gefunden wird, der ausreichend gro&szlig; ist, so wird dieser Speicherblock ausgew&auml;hlt<br/>"
	    	+ "und die Suche wird beendet.<br/>"
	    	+ "<br/>"
	    	+ "<h3>Next-Fit:</h3>"
	    	+ "Die Liste der Speicherbl&ouml;cke wird ab dem letzen ausgew&auml;hten Speicherblock bis zum letzten Speicherblock<br/>"
	    	+ "in der Liste durchsucht. Wenn der letzte Speicherblock in der Liste erreicht ist, so wird die Liste ab dem<br/>"
	    	+ "ersten Speicherblock bis zum letzten ausgew&auml;hten Speicherblockder der Liste weiter durchsucht.<br/>"
	    	+ "Wenn ein Speicherblock gefunden wird, der ausreichend gro&szlig; ist, so wird dieser Speicherblock ausgew&auml;hlt<br/>"
	    	+ "und die Suche wird beendet.<br/>"
	    	+ "<br/>"
	    	+ "<h3>Best-Fit:</h3>"
	    	+ "Die Liste der Speicherbl&ouml;cke wird ab dem ersten bis zum letzten Speicherblock in der Liste durchsucht.<br/>"
	    	+ "Es wird der Speicherblock gew&auml;hlt, bei dem am wenigsten Rest bzw. Verschnitt &uuml;brig bleibt.<br/>"
	    	+ "Wenn ein Speicherblock gefunden wird, der passend ist, so wird dieser Speicherblock ausgew&auml;hlt<br/>"
	    	+ "und die Suche wird beendet.<br/>"
	    	+ "<br/>"
	    	+ "<h3>Worst-Fit:</h3>"
	    	+ "Die Liste der Speicherbl&ouml;cke wird ab dem ersten bis zum letzten Speicherblock in der Liste durchsucht.<br/>"
	    	+ "Es wird der Speicherblock ausgew&auml;hlt, bei dem am meisten Rest bzw. Verschnitt &uuml;brig bleibt.<br/>"
	    	+ "<br/>"
	    	+ "<h3>Schneiderinnen-Best-Fit:</h3>"
	    	+ "Die Liste der Speicherbl&ouml;cke wird ab dem ersten bis zum letzten Speicherblock in der Liste durchsucht.<br/>"
	    	+ "Es wird der Speicherblock ausgew&auml;hlt, bei dem am meisten Rest bzw. Verschnitt &uuml;brig bleibt.<br/>"
	    	+ "Wenn ein Speicherblock gefunden wird, der passend ist, so wird dieser Speicherblock ausgew&auml;hlt<br/>"
	    	+ "und die Suche wird beendet.<br/>"
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

	@Override
	public String getToolTipHauptspeicher() {
		String tooltipHauptspeicher = ""
	    	+ "<html>"
	    	+ "einzelne Speichergr&ouml;&szlig;en, durch Komma getrennt ohne Leerzeichen, eintragen"
	    	+ "</html>";
		return tooltipHauptspeicher;
	}
}
