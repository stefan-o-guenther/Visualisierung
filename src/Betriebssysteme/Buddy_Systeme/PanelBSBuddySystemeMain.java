/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

import Base.BasePanelMain;
import Base.BasePanelModel;
import Base.PanelTitle;

public class PanelBSBuddySystemeMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeMain() {
		super(new BuddyMemoryAllocation());
		initComponents();
	}
	
	/*
	 * 
	 * 





Ihre Anfangsadressen sind identisch bis auf das k-te Bit in ihrer Adresse, das invertiert ist. Beispiel: ...XYZ0000... und ...XYZ1000... sind die Anfangsadressen von Partnern.

Dies lässt sich ausnutzen, um sehr schnell (in einem Schritt!) prüfen zu können, ob ein freigewordenes Speicherstück einen freien Partner in der Belegungstabelle hat, mit dem es zu einem (doppelt so großen) Stück verschmolzen werden kann.

Beide Vorgänge, sowohl das Suchen eines passenden freien Stücks (bzw. das dafür nötigen Auseinanderbrechen eines größeren) als auch das Zusammenfügen zu größeren Einheiten lässt sich rekursiv über mehrere Partnerebenen (mehrere Zweierpotenzen) durchführen.
	 * 
	 * 
	 * 
	 * 
	 *
	 * */
	
	
	protected PanelBSBuddySystemeExplanationScroll panelExplanation;
	
	protected void initComponents() {
		IBuddyMemoryAllocation buddy = (IBuddyMemoryAllocation) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Für jede gängige Belegungsgröße (am besten Speicher in den Größen von Zweierpotenzen)<br>"
	        	+ "wird eine eigene Liste vorgesehen und nur Speicherstücke einer solchen festen Größe vergeben.<br>"
	        	+ "Alle Anforderungen müssen also auf die nächste Zweierpotenz aufgerundet werden.<br>"
	        	+ "<br>"
	        	+ "Ein Speicherplatz der Länge 280 Bytes = 256+16+8 = 28 + 24 + 23 Bytes muss also auf 29 = 512 Bytes aufgerundet werden.<br>"
	        	+ "<br>"
	        	+ "Ist kein freies Speicherstück der Größe 2k vorhanden, so muss ein freies Speicherstück der Größe 2k+1 in zwei Stücke von je 2k Byte aufgeteilt werden. <br>"
	        	+ "Beide Stücke, die Partner (Buddy), sind genau gekennzeichnet:<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelBSBuddySystemeModel(buddy);
		//panelModel = new PanelBSBuddySystemeModelScroll(buddy);
		panelMenu = new PanelBSBuddySystemeMenu(buddy, panelModel);
		panelTitle = new PanelTitle(buddy, panelModel, "Buddy Systeme", tooltip);
		initLayout(110);
	}
		
	
}
