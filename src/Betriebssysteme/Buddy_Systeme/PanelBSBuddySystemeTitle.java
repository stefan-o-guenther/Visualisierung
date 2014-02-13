/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelTitle;

public class PanelBSBuddySystemeTitle extends BasePanelTitle {
	
	public PanelBSBuddySystemeTitle(IBuddyMemoryAllocation buddy) {
		super(buddy);
	}

	@Override
	protected String getToolTip() {
		String tooltipBSBuddySysteme = ""
			+ "<html>"
			+ "<p>"
			+ "Für jede gängige Belegungsgröße (am besten Speicher in den Größen von Zweierpotenzen)<br/>"
			+ "wird eine eigene Liste vorgesehen und nur Speicherstücke einer solchen festen Größe vergeben.<br/>"
			+ "Alle Anforderungen müssen also auf die nächste Zweierpotenz aufgerundet werden.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ein Speicherplatz der Länge 280 Bytes = 256+16+8 = 2<sup>8</sup> + 2<sup>4</sup> + 2<sup>3</sup> Bytes<br/>"
			+ "muss also auf 2<sup>9</sup> = 512 Bytes aufgerundet werden.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ist kein freies Speicherstück der Größe 2<sup>k</sup> vorhanden, so muss ein freies<br/>"
			+ "Speicherstück der Größe 2<sup>k+1</sup> in zwei Stücke von je 2<sup>k</sup> Byte aufgeteilt<br/>"
			+ "werden. Beide Stücke, die <strong>Partner (Buddy)</strong>, sind genau gekennzeichnet:<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ihre Anfangsadressen sind identisch bis auf das k-te Bit in ihrer Adresse, das invertiert ist.<br/>"
			+ "Beispiel: ...XYZ0000... und ...XYZ1000... sind die Anfangsadressen von Partnern.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Dies lässt sich ausnutzen, um sehr schnell (in einem Schritt!) prüfen zu können, ob ein<br/>"
			+ "freigewordenes Speicherstück einen freien Partner in der Belegungstabelle hat, mit dem<br/>"
			+ "es zu einem (doppelt so großen) Stück verschmolzen werden kann.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Beide Vorgänge, sowohl das Suchen eines passenden freien Stücks (bzw. das dafür nötigen<br/>"
			+ "Auseinanderbrechen eines größeren) als auch das Zusammenfügen zu größeren Einheiten lässt<br/>"
			+ "sich rekursiv schnell über mehrere Partnerebenen (mehrere Zweierpotenzen) durchführen.<br/>"
			+ "</p>"
			+ "</html>";
		return tooltipBSBuddySysteme;
	}


	@Override
	protected String getTitle() {
		return "Buddy Systeme";
	}
}
