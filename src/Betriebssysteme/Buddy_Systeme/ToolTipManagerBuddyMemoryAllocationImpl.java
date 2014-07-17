/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.ToolTipManager;

public class ToolTipManagerBuddyMemoryAllocationImpl implements ToolTipManagerBuddyMemoryAllocation {

	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
			+ "<p>"
			+ "F&uuml;r jede g&auml;ngige Belegungsgr&ouml;&szlig;e (am besten Speicher in den Gr&ouml;&szlig;en von Zweierpotenzen)<br/>"
			+ "wird eine eigene Liste vorgesehen und nur Speicherst&uuml;cke einer solchen festen Gr&ouml;&szlig;e vergeben.<br/>"
			+ "Alle Anforderungen m&uuml;ssen also auf die n&auml;chste Zweierpotenz aufgerundet werden.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ein Speicherplatz der L&auml;nge 280 Bytes = 256+16+8 = 2<sup>8</sup> + 2<sup>4</sup> + 2<sup>3</sup> Bytes<br/>"
			+ "muss also auf 2<sup>9</sup> = 512 Bytes aufgerundet werden.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ist kein freies Speicherst&uuml;ck der Gr&ouml;&szlig;e 2<sup>k</sup> vorhanden, so muss ein freies<br/>"
			+ "Speicherst&uuml;ck der Gr&ouml;&szlig;e 2<sup>k+1</sup> in zwei St&uuml;cke von je 2<sup>k</sup> Byte aufgeteilt<br/>"
			+ "werden. Beide St&uuml;cke, die <strong>Partner (Buddy)</strong>, sind genau gekennzeichnet:<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ihre Anfangsadressen sind identisch bis auf das k-te Bit in ihrer Adresse, das invertiert ist.<br/>"
			+ "Beispiel: ...XYZ0000... und ...XYZ1000... sind die Anfangsadressen von Partnern.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Dies l&auml;sst sich ausnutzen, um sehr schnell (in einem Schritt!) pr&uuml;fen zu k&ouml;nnen, ob ein<br/>"
			+ "freigewordenes Speicherst&uuml;ck einen freien Partner in der Belegungstabelle hat, mit dem<br/>"
			+ "es zu einem (doppelt so gro&szlig;en) St&uuml;ck verschmolzen werden kann.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Beide Vorg&auml;nge, sowohl das Suchen eines passenden freien St&uuml;cks (bzw. das daf&uuml;r n&ouml;tigen<br/>"
			+ "Auseinanderbrechen eines gr&ouml;&szlig;eren) als auch das Zusammenf&uuml;gen zu gr&ouml;&szlig;eren Einheiten l&auml;sst<br/>"
			+ "sich rekursiv schnell &uuml;ber mehrere Partnerebenen (mehrere Zweierpotenzen) durchf&uuml;hren.<br/>"
			+ "</p>"
			+ "</html>";
		return tooltipTitle;
	}
	
	public String getToolTipSpaceSize() {
		String tooltipSpaceSize = ""
			+ "<html>"
			+ "Da der BuddySystem-Algorithmus immer mit Bl&ouml;cken der L&auml;nge 2<sup>k</sup> arbeitet,<br/>"
			+ "wird jede Eingabe auf die n&auml;chst h&ouml;herliegende 2er-Potzenzzahl gerundet.<br/>"
			+ "</<html>";
		return tooltipSpaceSize;
	}
	
	public String getToolTipProcessName() {
		String tooltipProcessName = ""
			+ "<html>"
			+ "Name für einen Prozess. Der Name darf aus h&ouml;chstens 6 Zeichen bestehen.<br/>"
			+ "</<html>";
		return tooltipProcessName;
	}
	
	public String getToolTipProcessSize() {
		String tooltipProcessSize = ""
			+ "<html>"
			+ "Die Gr&ouml;&szlig;e des Prozesses darf nicht gr&ouml;&szlig;er sein als der gr&ouml;&szlig;te freie Speicherbereich.<br/>"
			+ "</<html>";
		return tooltipProcessSize;
	}	
	
	public String getToolTipLoadExample() {
		String tooltipLoadExample = ""
			+ "<html>"
			+ "Ein Bespielszenario, bei dem verschiedene Prozesse gestartet und gestoppt werden, wird geladen.<br/>"
			+ "</<html>";
		return tooltipLoadExample;
	}		
}
