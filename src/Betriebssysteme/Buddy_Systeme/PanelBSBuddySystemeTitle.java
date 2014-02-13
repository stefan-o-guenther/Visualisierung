/**
 * @author:	Stefan Otto G�nther
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
			+ "F�r jede g�ngige Belegungsgr��e (am besten Speicher in den Gr��en von Zweierpotenzen)<br/>"
			+ "wird eine eigene Liste vorgesehen und nur Speicherst�cke einer solchen festen Gr��e vergeben.<br/>"
			+ "Alle Anforderungen m�ssen also auf die n�chste Zweierpotenz aufgerundet werden.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ein Speicherplatz der L�nge 280 Bytes = 256+16+8 = 2<sup>8</sup> + 2<sup>4</sup> + 2<sup>3</sup> Bytes<br/>"
			+ "muss also auf 2<sup>9</sup> = 512 Bytes aufgerundet werden.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ist kein freies Speicherst�ck der Gr��e 2<sup>k</sup> vorhanden, so muss ein freies<br/>"
			+ "Speicherst�ck der Gr��e 2<sup>k+1</sup> in zwei St�cke von je 2<sup>k</sup> Byte aufgeteilt<br/>"
			+ "werden. Beide St�cke, die <strong>Partner (Buddy)</strong>, sind genau gekennzeichnet:<br/>"
			+ "</p>"
			+ "<p>"
			+ "Ihre Anfangsadressen sind identisch bis auf das k-te Bit in ihrer Adresse, das invertiert ist.<br/>"
			+ "Beispiel: ...XYZ0000... und ...XYZ1000... sind die Anfangsadressen von Partnern.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Dies l�sst sich ausnutzen, um sehr schnell (in einem Schritt!) pr�fen zu k�nnen, ob ein<br/>"
			+ "freigewordenes Speicherst�ck einen freien Partner in der Belegungstabelle hat, mit dem<br/>"
			+ "es zu einem (doppelt so gro�en) St�ck verschmolzen werden kann.<br/>"
			+ "</p>"
			+ "<p>"
			+ "Beide Vorg�nge, sowohl das Suchen eines passenden freien St�cks (bzw. das daf�r n�tigen<br/>"
			+ "Auseinanderbrechen eines gr��eren) als auch das Zusammenf�gen zu gr��eren Einheiten l�sst<br/>"
			+ "sich rekursiv schnell �ber mehrere Partnerebenen (mehrere Zweierpotenzen) durchf�hren.<br/>"
			+ "</p>"
			+ "</html>";
		return tooltipBSBuddySysteme;
	}


	@Override
	protected String getTitle() {
		return "Buddy Systeme";
	}
}
